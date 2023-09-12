package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Available_Material;
import com.Spring_Boot.Material_Inventory.model.Requested_Material;

import java.util.List;

public interface Available_Service_Interface {
    List<Available_Material> getAllMaterial();
    Available_Material saveMaterial(Available_Material availableMaterial);
    void deleteAvailableMaterialById(int id);

    void updateMaterial(String name, int qty);
}
