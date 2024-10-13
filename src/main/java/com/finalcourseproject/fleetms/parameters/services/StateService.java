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
    public List<State> findAllStates(){
        return stateRepository.findAll();
    }

    //Get State By Id
    public State findState(int id) {
        return stateRepository.findById(id).orElse(null);
    }

    //Delete State
    public void deleteState(int id) {
        stateRepository.deleteById(id);
    }

    //Update State
    public void saveState( State state) {
        stateRepository.save(state);
    }
}
