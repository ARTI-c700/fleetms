package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.State;
import com.finalcourseproject.fleetms.parameters.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    private final StateRepository stateRepository;
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    //Get All States
    public List<State> findAll(){
        return stateRepository.findAll();
    }

    //Get State By Id
    public State findById(int id) {
        return stateRepository.findById(id).orElse(null);
    }

    //Delete State
    public void delete(int id) {
        stateRepository.deleteById(id);
    }

    //Update State
    public void save( State state) {
        stateRepository.save(state);
    }
}
