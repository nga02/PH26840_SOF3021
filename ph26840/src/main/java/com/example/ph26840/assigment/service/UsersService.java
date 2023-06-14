package com.example.ph26840.assigment.service;

import com.example.ph26840.assigment.entity.Users;
import com.example.ph26840.assigment.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private IUsersRepository accountRepository;


    public List<Users> getList() {
        return accountRepository.findAll();
    }


    public Users insert(Users account) {
        return accountRepository.save(account);
    }


    public boolean delete(int id) {
        accountRepository.deleteById(id);
        return true;
    }


    public Users findByTen(String userName) {
        return null;
    }


    public Users findById(int id) {
        return accountRepository.findById(id).orElse(null);
    }


    public Users login(String username, String password) {
        Users account = accountRepository.findByTen(username);
        if (account != null && account.getPass().equals(password)) {
            return account;
        }
        return null;
    }

//    @Override
//    public boolean hasAdminRole(Users account) {
//        return account.getRole() == 0; // Kiểm tra role là admin
//    }
}
