package com.sophos.api.backend.service.impl;

import com.sophos.api.backend.models.AppointmentsModel;
import com.sophos.api.backend.repository.AppointmentsRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsService {

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	public ArrayList<AppointmentsModel> getList() {
		return (ArrayList<AppointmentsModel>) appointmentsRepository.findAll();

	}

	public Optional<AppointmentsModel> getById(Long id) {
		return appointmentsRepository.findById(id);

	}

	public AppointmentsModel post(AppointmentsModel appointments) {
		return appointmentsRepository.save(appointments);

	}

	public boolean deleteById(Long id) {
		try {
			appointmentsRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}

	}
}
