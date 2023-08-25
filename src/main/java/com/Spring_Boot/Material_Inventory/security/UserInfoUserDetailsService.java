package com.Spring_Boot.Material_Inventory.security;

import com.Spring_Boot.Material_Inventory.model.UserInfo;
import com.Spring_Boot.Material_Inventory.repository.UserInfo_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserInfoUserDetailsService /*implements UserDetailsService*/ {
    @Autowired
    private UserInfo_Repo userInfoRepo;

    public UserInfoUserDetailsService(){

    }

    public UserInfoUserDetailsService(UserInfo_Repo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //fetching user from database.
//        UserInfo user = userInfoRepo.getUserByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("could not found");
//        }
//        UserInfoDetails userInfoDetails = new UserInfoDetails(user);
//        return userInfoDetails;
//
//    }
}
