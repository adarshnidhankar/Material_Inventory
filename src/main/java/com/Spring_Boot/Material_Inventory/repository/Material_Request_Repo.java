package com.Spring_Boot.Material_Inventory.repository;

import com.Spring_Boot.Material_Inventory.model.Requested_Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Material_Request_Repo extends JpaRepository<Requested_Material,Integer> {
}
