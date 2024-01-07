package com.spring.restaurant.service;

import com.spring.restaurant.dao.CountryRepository;
import com.spring.restaurant.entity.Country;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {


    private CountryRepository countryRepository;


    public List<Country> getAllCountry()
    {
        return countryRepository.findAll();
    }

}
