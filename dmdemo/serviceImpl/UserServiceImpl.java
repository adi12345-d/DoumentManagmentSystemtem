package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.InvalidUserException;
import com.document.dmdemo.exception.UserNotFoundException;
import com.document.dmdemo.model.UserEntity;
import com.document.dmdemo.repo.UserRepository;
import com.document.dmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser (UserEntity user) {
        validateUser (user);
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser (UserEntity user) {
        if (!userRepository.existsById(user.getId())) {
            throw new UserNotFoundException("User  not found with ID: " + user.getId());
        }
        validateUser (user);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser (Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User  not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User  not found with ID: " + userId));
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User  not found with username: " + username));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    private void validateUser (UserEntity user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new InvalidUserException("Username cannot be empty.");
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new InvalidUserException("Invalid email format.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new InvalidUserException("Password must be at least 6 characters long.");
        }
    }
}