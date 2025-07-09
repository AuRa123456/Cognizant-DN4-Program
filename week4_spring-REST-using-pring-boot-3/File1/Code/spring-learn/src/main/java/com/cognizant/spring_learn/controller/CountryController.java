package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        Country country = countryService.findCountryByCode(code);
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return ResponseEntity.ok(country);
    }

    @PutMapping("/{code}")
    public ResponseEntity<String> updateCountry(@PathVariable String code, @RequestBody Country updated)
            throws CountryNotFoundException {
        countryService.updateCountry(code, updated.getName());
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return ResponseEntity.ok("Deleted");
    }
}