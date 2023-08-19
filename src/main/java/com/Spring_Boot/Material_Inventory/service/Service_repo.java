package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Material;

import java.util.List;

public interface Service_repo {
    List<Material> getAllMaterial();

    Material saveMaterial(Material material);

    Material getMaterialId(int id);

    Material updateMaterial(Material material);

    void deleteMaterialById(int id);
}
