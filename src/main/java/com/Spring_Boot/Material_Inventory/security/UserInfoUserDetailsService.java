package com.Spring_Boot.Material_Inventory.security;

import com.Spring_Boot.Material_Inventory.model.UserInfo;
import com.Spring_Boot.Material_Inventory.repository.UserInfo_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfo_Repo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = userInfoRepo.findByUserName(username);
        return user.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

    }
}
