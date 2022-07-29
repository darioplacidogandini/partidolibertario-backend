package com.dariogandini.partidolibertariobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dariogandini.partidolibertariobackend.model.Afiliados;
import com.dariogandini.partidolibertariobackend.repository.AfiliadosRepository;

@CrossOrigin(origins = {"https://partidolibertariocorrientes.firebaseapp.com",
"https://partidolibertariocorrientes.web.app"})
@RestController
@RequestMapping("/api/afiliados")
public class AfiliadosController {

    @Autowired
    private AfiliadosRepository afiliadosRepository;

    @GetMapping("/list")
    public List<Afiliados> list() {
        return afiliadosRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Afiliados> search(@PathVariable Long id) {
        Afiliados afiliados = afiliadosRepository.findById(id).orElse(null);
        return ResponseEntity.ok(afiliados);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Afiliados> edit(@PathVariable Long id, 
    @RequestBody Afiliados afiliadosDetails) {
        Afiliados afiliados = afiliadosRepository.findById(id).orElse(null);
        afiliados.setNombre(afiliadosDetails.getNombre());
        afiliados.setApellido(afiliadosDetails.getApellido());
        afiliados.setDni(afiliadosDetails.getDni());
        afiliados.setCircuito(afiliadosDetails.getCircuito());
        afiliados.setMail(afiliadosDetails.getMail());
        afiliados.setTelefono(afiliadosDetails.getTelefono());
        afiliados.setObservaciones(afiliadosDetails.getObservaciones());
        Afiliados editedAbout = afiliadosRepository.save(afiliados);
        return ResponseEntity.ok(editedAbout);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") Long afiliadosId) {
        Afiliados afiliados = afiliadosRepository.findById(afiliadosId).orElse(null);
        afiliadosRepository.delete(afiliados);
    }
}

