package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.model.Requested_Material;

import java.util.List;

public interface Material_Request_Service_Interface {
    List<Requested_Material> getAllMaterial();
    Requested_Material saveMaterial(Requested_Material material);

    void deleteRequestedMaterial(int id);
}
