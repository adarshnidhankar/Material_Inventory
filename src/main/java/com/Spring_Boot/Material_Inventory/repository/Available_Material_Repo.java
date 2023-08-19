package com.Spring_Boot.Material_Inventory.repository;

import com.Spring_Boot.Material_Inventory.model.Available_Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Available_Material_Repo extends JpaRepository<Available_Material,Integer> {
}
