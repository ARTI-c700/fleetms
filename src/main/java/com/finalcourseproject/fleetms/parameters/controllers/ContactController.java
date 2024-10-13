package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Contact;
import com.finalcourseproject.fleetms.parameters.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/parameters/contacts")
    public String getAll(Model model) {
        List<Contact> contacts = contactService.findAllContacts();
        model.addAttribute("contacts", contacts);
        return "/parameters/contacts";
    }

    @GetMapping("/parameters/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable Integer id) {
        return contactService.findContact(id);
    }

    @GetMapping("/parameters/contactAdd")
    public String addContact(Model model) {
        return "parameters/contactAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/contact/{op}/{id}")
    public String editContact(@PathVariable Integer id, @PathVariable String op, Model model){
        Contact contact = contactService.findContact(id);
        model.addAttribute("contact", contact);
        return "/parameters/contact"+ op;
    }

    @PostMapping("/parameters/contacts")
    public String save(Contact contact){
        contactService.saveContact(contact);
        return "redirect:/parameters/contacts";
    }

    @RequestMapping(value = "/parameters/contacts/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        contactService.deleteContact(id);
        return "redirect:/parameters/contacts";
    }
}
