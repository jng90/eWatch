package com.example.ewatch.service;


import com.example.ewatch.model.User;
import com.example.ewatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void add(User user){
        log.info("Add: " + user);
        userRepository.save(user);
    }

}
