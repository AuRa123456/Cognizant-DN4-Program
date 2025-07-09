package com.cognizant.spring_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@SpringBootApplication
public class SpringLearnApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountryByCode() throws Exception {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }

    private static void testAddCountry() throws Exception {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");
        countryService.addCountry(country);
        LOGGER.debug("Added: {}", countryService.findCountryByCode("ZZ"));
        LOGGER.info("End");
    }

    private static void testUpdateCountry() throws Exception {
        LOGGER.info("Start");
        countryService.updateCountry("ZZ", "Zootopia Republic");
        LOGGER.debug("Updated: {}", countryService.findCountryByCode("ZZ"));
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.info("Deleted ZZ");
        LOGGER.info("End");
    }
}