package com.example.signin.controller;

import java.util.List;

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

import com.example.signin.model.Client;
import com.example.signin.service.SigninService;

@RestController
@RequestMapping("/api")
public class SigninController {
    @Autowired
    private final SigninService signinService;

    public SigninController(SigninService signinService) {
        this.signinService = signinService;
    }

    @PostMapping("/signin")
    // insert the data
    public ResponseEntity<Client> createSignin(@RequestBody Client client) {
        Client createSignin = signinService.createSignin(client);
        return new ResponseEntity<>(createSignin, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<List<Client>> getAllSignin() {
        List<Client> client = signinService.getAllSignin();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/signin/{signinId}")
    public ResponseEntity<Client> getById(@PathVariable int signinId) {
        Client client = signinService.getSigninId(signinId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/signin/{id}")
    public ResponseEntity<Client> update(@PathVariable int id, @RequestBody Client client) {
        return new ResponseEntity<>(signinService.update(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/signin/{signId}")
    public ResponseEntity<Void> delete(@PathVariable int signId) {
        signinService.delete(signId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{signinName}")
    public ResponseEntity<List<Client>> sortTheRecords(@PathVariable String signinName) {
        List<Client> field = signinService.sortTheRecords(signinName);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Client>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size) {
        List<Client> list = signinService.getPaginationSignin(offset, size);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Client>> getSortedPagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size, @PathVariable("field") String field) {
        List<Client> list = signinService.getSortedPaginationSignin(offset, size, field);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
