package com.sophos.api.backend.controllers;

import com.sophos.api.backend.models.AppoinmentsModel;
import com.sophos.api.backend.service.AppoinmentsService;
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

@RequestMapping(path = "/datacontroller/api")
@RestController
public class AppoinmentsController {

    @Autowired
    private AppoinmentsService appoinmentsService;

    @GetMapping(path = "/appoinments/get")
    public ArrayList<AppoinmentsModel> getList() {
        return appoinmentsService.getList();

    }

    @GetMapping(path = "/appoinments/get/{id}")
    public Optional<AppoinmentsModel> getById(@PathVariable("id") Long id) {
        return this.appoinmentsService.getById(id);

    }

    @PostMapping(path = "/appoinments/post")
    public AppoinmentsModel post(@RequestBody AppoinmentsModel appoinments) {
        return this.appoinmentsService.post(appoinments);

    }

    @PutMapping(path = "/appoinments/put")
    public AppoinmentsModel put(@RequestBody AppoinmentsModel appoinments) {
        return this.appoinmentsService.post(appoinments);
    }

    @DeleteMapping(path = "/appoinments/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.appoinmentsService.deleteById(id);
        if (ok) {
            return "Registro eliminado";
        } else {
            return "No se elimino el registro";
        }
    }
}
