package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Available_Material;
import com.Spring_Boot.Material_Inventory.repository.Available_Material_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Available_Material_Service implements Available_Service_Interface{

    @Autowired
    private Available_Material_Repo material_repo;

    @Override
    public List<Available_Material> getAllMaterial() {
        return material_repo.findAll();
    }

    @Override
    public Available_Material saveMaterial(Available_Material availableMaterial) {
        return material_repo.save(availableMaterial);
    }
}
