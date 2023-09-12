package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Available_Material;
import com.Spring_Boot.Material_Inventory.repository.Available_Material_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class Available_Material_Service implements Available_Service_Interface {

    @Autowired
    private Available_Material_Repo material_repo;

    static CallableStatement callableStatement;
    static Connection connection;

    @Override
    public List<Available_Material> getAllMaterial() {
        return material_repo.findAll();
    }

    public Available_Material getMaterialId(int id) {
        return material_repo.findById(id).get();
    }

    @Override
    public Available_Material saveMaterial(Available_Material availableMaterial) {
        return material_repo.save(availableMaterial);
    }

    @Override
    public void deleteAvailableMaterialById(int id) {
        material_repo.deleteById(id);
    }

    @Override
    public void updateMaterial(String name, int qty) {
        try {
            callableStatement = connection.prepareCall("{call updateMaterial(?,?)}");
            callableStatement.setString(1,name);
            callableStatement.setInt(2,qty);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
