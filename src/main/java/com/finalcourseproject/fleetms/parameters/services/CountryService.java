package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Country;
import com.finalcourseproject.fleetms.parameters.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

//    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }

    public Country findCountry(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }
}
