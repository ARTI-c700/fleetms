package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Country;
import com.finalcourseproject.fleetms.parameters.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

//    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
