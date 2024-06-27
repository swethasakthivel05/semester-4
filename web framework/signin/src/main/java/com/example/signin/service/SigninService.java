package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.signin.model.Client;
import com.example.signin.repository.SigninRepository;

@Service
public class SigninService {
    @Autowired
    private final SigninRepository signinRepository;

    public SigninService(SigninRepository signinRepository) {
        this.signinRepository = signinRepository;
    }

    public Client createSignin(Client client) {
        return signinRepository.save(client);
    }

    public List<Client> getAllSignin() {
        return signinRepository.findAll();
    }

    public Client getSigninId(int clientId) {
        return signinRepository.findById(clientId).orElse(null);
    }

    public Client update(int id, Client client) {
        Client pros = signinRepository.findById(id).orElse(null);
        if (pros != null) {
            pros.setNo(client.getNo());
            pros.setUsername(client.getUsername());
            pros.setPassword(client.getPassword());
            return signinRepository.save(pros);
        }
        return client;
    }

    public void delete(int clientId) {
        signinRepository.deleteById(clientId);

    }

    public List<Client> sortTheRecords(String clientName) {
        return signinRepository.findAll(Sort.by(Sort.Direction.DESC, clientName));
    }

    public List<Client> getPaginationSignin(int offset, int size) {
        return signinRepository.findAll(PageRequest.of(offset, size)).getContent();
    }

    public List<Client> getSortedPaginationSignin(int offset, int size, String field) {
        return signinRepository.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}
