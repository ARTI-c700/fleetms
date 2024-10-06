package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Contact;
import com.finalcourseproject.fleetms.parameters.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    //Get All Contacts
    public List<Contact> findAllContacts(){
        return contactRepository.findAll();
    }

    //Get Contact By id
    public Contact findContactById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    //Delete Contact
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }

    //Update Contact
    public void saveContact( Contact contact) {
        contactRepository.save(contact);
    }
}
