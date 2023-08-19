package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.model.Requested_Material;
import com.Spring_Boot.Material_Inventory.repository.Material_Request_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Material_Request_Service implements Material_Request_Service_Interface {

    @Autowired
    private Material_Request_Repo requestRepo;

    @Override
    public List<Requested_Material> getAllMaterial() {
        return requestRepo.findAll();
    }

    @Override
    public Requested_Material saveMaterial(Requested_Material material) {
        return requestRepo.save(material);
    }

    public void updateQuantity(int qty, Material material) {
        
    }
}
