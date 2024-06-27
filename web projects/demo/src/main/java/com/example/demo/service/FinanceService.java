package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.repository.UserRepo;

@Service
public class FinanceService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserById(int id) {
        return ResponseEntity.ok(userRepo.findById(id).orElse(null));
    }

    public ResponseEntity<Void> deleteUser(int id) {
        userRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<User> updateUser(int id, User userDetails) {
        Optional<User> existingUser = userRepo.findById(id);

        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = existingUser.get();
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        return ResponseEntity.ok(userRepo.save(user));
    }

    public ResponseEntity<Transaction> createTransaction(Transaction transaction) {
        return new ResponseEntity<>(transactionRepo.save(transaction), HttpStatus.CREATED);
    }

    public ResponseEntity<Transaction> getTransactionById(int id) {
        return ResponseEntity.ok(transactionRepo.findById(id).orElse(null));
    }

    public ResponseEntity<List<Transaction>> getTransactionsByUserId(int userId) {
        return ResponseEntity.ok(transactionRepo.findByUserId(userId));
    }

    public ResponseEntity<Void> deleteTransaction(int id) {
        transactionRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Transaction> updateTransaction(int id, Transaction transactionDetails) {
        Optional<Transaction> existingTransaction = transactionRepo.findById(id);

        if (existingTransaction.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Transaction transaction = existingTransaction.get();
        transaction.setType(transactionDetails.getType());
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDescription(transactionDetails.getDescription());
        return ResponseEntity.ok(transactionRepo.save(transaction));
    }

}
