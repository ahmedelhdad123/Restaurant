package com.spring.restaurant.service;

import com.spring.restaurant.dao.StateRepository;
import com.spring.restaurant.entity.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StateService {

    private StateRepository stateRepository;


    public List<State> getAllState()
    {
        return stateRepository.findAll();
    }

    public List<State> getStateByCountryCode(String code)
    {
        return  stateRepository.findAll()
                .stream()
                .filter(state -> state.getCountry().getCode().equalsIgnoreCase(code))
                .collect(Collectors.toList());
    }

    

}
