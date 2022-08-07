package com.example.mf2.services;

import com.example.mf2.entities.User;
import com.example.mf2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> getAdmins() {
        return userRepository.findAll().stream().filter(user -> user.getRole_id()==1).toList();
    }

    public List<User> getManagers() {
        return userRepository.findAll().stream().filter(user -> user.getRole_id()==2).toList();
    }

    public List<User> getMentors() {
        return userRepository.findAll().stream().filter(user -> user.getRole_id()==3).toList();
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }


    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = getByEmail(email);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", email));
        }
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
