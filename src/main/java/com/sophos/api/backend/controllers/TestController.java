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

import com.sophos.api.backend.models.TestModel;
import com.sophos.api.backend.service.TestService;

@RequestMapping(path = "/datacontroller/api")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(path = "/test/get")
    public ArrayList<TestModel> getList() {
        return testService.getList();

    }

    @GetMapping(path = "/test/get/{id}")
    public Optional<TestModel> getById(@PathVariable("id") Long id) {
        return this.testService.getById(id);

    }

    @PostMapping(path = "/test/post")
    public TestModel post(@RequestBody TestModel test) {
        return this.testService.post(test);

    }

    @PutMapping(path = "/test/put")
    public TestModel put(@RequestBody TestModel test) {
        return this.testService.post(test);
    }

    @DeleteMapping(path = "/test/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.testService.deleteById(id);
        if (ok) {
            return "Registro eliminado";
        } else {
            return "No se elimino el registro";
        }
    }

}
