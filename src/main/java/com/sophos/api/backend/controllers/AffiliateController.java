package com.sophos.api.backend.controllers;

import com.sophos.api.backend.models.AffiliateModel;
import com.sophos.api.backend.service.AffiliateService;
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
public class AffiliateController {

    @Autowired
    private AffiliateService affiliateService;

    @GetMapping(path = "/affiliate/get")
    public ArrayList<AffiliateModel> getList() {
        return affiliateService.getList();

    }

    @GetMapping(path = "/affiliate/get/{id}")
    public Optional<AffiliateModel> getById(@PathVariable("id") Long id) {
        return this.affiliateService.getById(id);

    }

    @PostMapping(path = "/affiliate/post")
    public AffiliateModel post(@RequestBody AffiliateModel affiliate) {
        return this.affiliateService.post(affiliate);

    }

    @PutMapping(path = "/affiliate/put")
    public AffiliateModel put(@RequestBody AffiliateModel affiliate) {
        return this.affiliateService.post(affiliate);
    }

    @DeleteMapping(path = "/affiliate/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.affiliateService.deleteById(id);
       if (ok) {
            return "Registro eliminado";
        } else {
            return "No se elimino el registro";
        }
}
}
