package com.eustache.auto_trader.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eustache.auto_trader.Entity.User;
import com.eustache.auto_trader.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
