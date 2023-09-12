package com.Spring_Boot.Material_Inventory.service;

import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.repository.Material_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    //calling stored procedure.
    private final JdbcTemplate jdbcTemplate;

    public Material_Service(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callProcedure(int id) {
        String query = " Select name, quantity from material_request where id =" + id + " ";
        List<Map<String, Object>> materialList = jdbcTemplate.queryForList(query);
        for (Map<String, Object> materialValue : materialList) {
            String m_name = (String) materialValue.get("name");
            int m_qty = (int) materialValue.get("quantity");

            jdbcTemplate.update("call updateMaterial(?,?)", m_name, m_qty);
        }
    }
}
