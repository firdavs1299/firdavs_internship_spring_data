package com.example.mf2.auth;

import com.example.mf2.entities.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;


    @Autowired
    public ApplicationUserService(@Qualifier("usersdb") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("/////////////////////");
        ApplicationUser applicationUser = null;

        try {
            applicationUser = applicationUserDao.selectApplicationUserByUsername(username).orElse(new ApplicationUser(null,null,null,false,false,false,false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return applicationUser;
    }
}
