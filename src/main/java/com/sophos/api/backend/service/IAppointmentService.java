package com.sophos.api.backend.service;

import java.util.ArrayList;
import java.util.Optional;
import com.sophos.api.backend.models.AppointmentsModel;

public interface IAppointmentService {

	ArrayList<AppointmentsModel> getList();

	Optional<AppointmentsModel> getById(Long id);

	AppointmentsModel post(AppointmentsModel test);

	AppointmentsModel put(AppointmentsModel test);

	boolean deleteById(Long id);

}
