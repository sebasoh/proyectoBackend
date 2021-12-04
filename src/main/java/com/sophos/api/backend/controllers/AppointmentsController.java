package com.sophos.api.backend.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.api.backend.models.AppointmentsModel;
import com.sophos.api.backend.service.impl.AppointmentsService;

@RequestMapping("/datacontroller/api/appointments")
@RestController
public class AppointmentsController {

	@Autowired
	private AppointmentsService appointmentsService;

	@GetMapping("/get")
	public ArrayList<AppointmentsModel> getList() {
		return appointmentsService.getList();

	}

	@GetMapping("/get/{id}")
	public Optional<AppointmentsModel> getById(@PathVariable("id") Long id) {
		return this.appointmentsService.getById(id);

	}

	@PostMapping("/post")
	public AppointmentsModel post(@RequestBody AppointmentsModel appointments) {
		return this.appointmentsService.post(appointments);

	}

	@PutMapping("/put")
	public AppointmentsModel put(@RequestBody AppointmentsModel appointments) {
		return this.appointmentsService.post(appointments);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.appointmentsService.deleteById(id);
		if (ok) {
			return "Registro eliminado";
		} else {
			return "No se elimino el registro";
		}
	}
}
