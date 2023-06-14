package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.Users;
import com.example.ph26840.assigment.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository repository;

    public void save(Users user) {
        repository.save(user);
    }

    public boolean checkUsername(String email) {
        Users users = repository.findByEmail(email);
        return users!=null;

    }

    public void updatePassword(Users user, String newPassword) {
        user.setPass(newPassword);
        repository.save(user);
    }
}
