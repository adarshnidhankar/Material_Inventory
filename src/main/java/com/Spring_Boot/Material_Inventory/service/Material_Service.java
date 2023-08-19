package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.repository.Material_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Material_Service implements Service_repo {
    @Autowired
    Material_Repository materialRepository;


    @Override
    public List<Material> getAllMaterial() {
        return materialRepository.findAll();
    }

    @Override
    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material getMaterialId(int id) {
        return materialRepository.findById(id).get();
    }


    @Override
    public Material updateMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteMaterialById(int id) {
        materialRepository.deleteById(id);
    }

}
