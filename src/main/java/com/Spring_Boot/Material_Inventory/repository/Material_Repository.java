package com.Spring_Boot.Material_Inventory.repository;

import com.Spring_Boot.Material_Inventory.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Material_Repository extends JpaRepository<Material,Integer> {

}
