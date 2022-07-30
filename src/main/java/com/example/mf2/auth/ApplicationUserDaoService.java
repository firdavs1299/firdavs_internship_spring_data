package com.example.mf2.auth;

import com.example.mf2.entities.User;
import com.example.mf2.repositories.UserRepository;
import com.example.mf2.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("usersdb")
public class ApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) throws IOException {
        System.out.println("username is "+username);
        if(getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).toList().size()==0){
            throw new IOException(String.format("user with user name %s not found", username));
        }
        else if (!getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst().get().isEnabled()){
            throw new IOException("user is not active");
        }
           Optional<ApplicationUser> user = getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
            return user;

    }
    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers=new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(var user: users){

            List<ApplicationUserRole> roles = new ArrayList<>();
            if(user.getRole_id()==1){
                roles.add(ApplicationUserRole.ADMIN);
                roles.add(ApplicationUserRole.MANAGER);
                roles.add(ApplicationUserRole.MENTOR);

            }
            else if(user.getRole_id()==2){
                roles.add(ApplicationUserRole.MANAGER);
            }
            else {
                roles.add(ApplicationUserRole.MENTOR);
            }

            ApplicationUser applicationUser = new ApplicationUser(
                    user.getEmail(),
                    user.getPassword(),
                    roles,
                    true,
                    true,
                    true,
                    user.isActive()
            );

            applicationUsers.add(applicationUser);
        }

        return applicationUsers;
    }
}
