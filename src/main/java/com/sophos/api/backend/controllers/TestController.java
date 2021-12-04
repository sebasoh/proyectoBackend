package com.sophos.api.backend.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.api.backend.models.TestModel;
import com.sophos.api.backend.service.ITestService;

@RequestMapping("/datacontroller/api/test")
@RestController
public class TestController {

	@Autowired
	private ITestService testService;

	@GetMapping("/get")
	public ResponseEntity<ArrayList<TestModel>> getList() {
		ArrayList<TestModel> tests = testService.getList();
		if (tests == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
		return ResponseEntity.status(HttpStatus.OK).body(tests);

	}

	@GetMapping("/get/{id}")
	public Object getById(@PathVariable("id") Long id) {
		TestModel test = testService.getById(id);
		if (test != null) {
			return ResponseEntity.status(HttpStatus.OK).body(test);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el registro");
	}

	@PostMapping("/post")
	public ResponseEntity<TestModel> post(@RequestBody TestModel test) {
		if (test.getId() == null) {

			TestModel nuevoTest = testService.post(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTest);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Object> put(@PathVariable("id") Long id, @RequestBody TestModel test) {
		Optional<TestModel> testFound = Optional.ofNullable((testService.getById(test.getId())));
		if (testFound.isPresent()) {
			TestModel testMod = testService.put(test, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(testMod);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en Base de Datos");
	}

	@DeleteMapping("/delete/{id}")
	public Object deleteById(@PathVariable("id") Long id) {
		// TestModel test = testService.getById(id);
		boolean ok = this.testService.deleteById(id);
		if (ok) {

			return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado satisfactoriamente");

		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

}
