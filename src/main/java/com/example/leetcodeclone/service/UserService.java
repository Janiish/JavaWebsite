package com.example.leetcodeclone.service;

import com.example.leetcodeclone.model.User;
import com.example.leetcodeclone.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Page<User> list(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public java.util.List<User> listAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Transactional
    public User update(Long id, User patch) {
        User existing = get(id);
        if (patch.getUsername() != null) existing.setUsername(patch.getUsername());
        if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
        if (patch.getPasswordHash() != null) existing.setPasswordHash(patch.getPasswordHash());
        return userRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
