package com.Spring_Boot.Material_Inventory.repository;

import com.Spring_Boot.Material_Inventory.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfo_Repo extends JpaRepository<UserInfo,Integer> {
    Optional<UserInfo> findByUserName(String username);
}
