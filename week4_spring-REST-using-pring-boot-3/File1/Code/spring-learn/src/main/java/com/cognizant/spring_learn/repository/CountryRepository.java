package com.cognizant.spring_learn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}