package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {

    private static final List<Country> COUNTRY_LIST = new ArrayList<>();

    static {
        COUNTRY_LIST.add(new Country("IN", "India"));
        COUNTRY_LIST.add(new Country("US", "United States"));
        COUNTRY_LIST.add(new Country("UK", "United Kingdom"));
        COUNTRY_LIST.add(new Country("AU", "Australia"));
    }

    public List<Country> getAllCountries() {
        return COUNTRY_LIST;
    }
}