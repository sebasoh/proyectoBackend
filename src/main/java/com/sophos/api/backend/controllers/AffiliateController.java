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

import com.sophos.api.backend.models.AffiliateModel;
import com.sophos.api.backend.service.IAffiliateService;

@RequestMapping("/datacontroller/api/affiliate")
@RestController
public class AffiliateController {

	@Autowired
	private IAffiliateService affiliateService;

	@GetMapping("/get")
	public ResponseEntity<ArrayList<AffiliateModel>> getList() {
		ArrayList<AffiliateModel> afiliados = affiliateService.getList();
		if (afiliados == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(afiliados);
		}

	}

	@GetMapping("/get/{id}")
	public Object getById(@PathVariable("id") Long id) {
		AffiliateModel affiliate = affiliateService.getById(id);
		if (affiliate == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el registro");
		}
		return ResponseEntity.status(HttpStatus.OK).body(affiliate);

	}

	@PostMapping("/post")
	public ResponseEntity<AffiliateModel> post(@RequestBody AffiliateModel affiliate) {
		if (affiliate.getId() == null) {
			AffiliateModel nuevoAfiliado = affiliateService.post(affiliate);
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAfiliado);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Object> put(@PathVariable("id") Long id, @RequestBody AffiliateModel affiliate) {
		Optional<AffiliateModel> affiliateFound = Optional.ofNullable(affiliateService.getById(id));
		if (affiliateFound.isPresent()) {
			AffiliateModel affiliateMod = affiliateService.put(affiliate, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateMod);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en Base de Datos");
	}

	@DeleteMapping("/delete/{id}")
	public Object deleteById(@PathVariable("id") Long id) {
		boolean ok = this.affiliateService.deleteById(id);
		if (ok) {
			return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado satisfactoriamente");
		} else {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
}
