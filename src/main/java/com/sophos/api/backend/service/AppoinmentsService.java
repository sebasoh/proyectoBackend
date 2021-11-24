package com.sophos.api.backend.service;

import com.sophos.api.backend.models.AppoinmentsModel;
import com.sophos.api.backend.repository.AppoinmentsRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentsService {

    @Autowired
    private AppoinmentsRepository appoinmentsRepository;

    public ArrayList<AppoinmentsModel> getList() {
        return (ArrayList<AppoinmentsModel>) appoinmentsRepository.findAll();

    }

    public Optional<AppoinmentsModel> getById(Long id) {
        return appoinmentsRepository.findById(id);

    }

    public AppoinmentsModel post(AppoinmentsModel appoinments) {
        return appoinmentsRepository.save(appoinments);

    }

    public boolean deleteById(Long id) {
        try {
            appoinmentsRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }

    }
}
