package com.example.demo.entity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void createUser(User user){
        try {
            userRepository.save(user);
        }catch (RuntimeException e){
            throw new RuntimeException("lỗi khi tạo user");
        }
    }
    public void deleteUser(Long id){
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("user id not existed ");
        }
        userRepository.deleteById(id);
    }
    public Optional<User> findUserById(Long id){
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("user id not existed ");
        }
        return userRepository.findById(id);
    }
}