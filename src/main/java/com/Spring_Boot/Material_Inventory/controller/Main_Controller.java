package com.Spring_Boot.Material_Inventory.controller;

import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.model.Requested_Material;
import com.Spring_Boot.Material_Inventory.service.Material_Request_Service;
import com.Spring_Boot.Material_Inventory.service.Material_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Main_Controller {
    @Autowired
    Material_Service materialService;

    @Autowired
    Material_Request_Service request_service;

    public Main_Controller(Material_Service materialService) {
        super();
        this.materialService = materialService;
    }

    @GetMapping("/")
    public String landingPage() {
        return "Home_Page";
    }

    @GetMapping("/getMaterial")
    public String materialList(Model model) {
        model.addAttribute("materials", materialService.getAllMaterial());
        return "/Store_Incharge";
    }

    @GetMapping("/addMaterial")
    public String addMaterial(Model model) {
        Material material = new Material();
        model.addAttribute("newMaterial", material);
        return "/Add_Material";
    }

    @PostMapping("/saveMaterial")
    public String saveMaterial(@ModelAttribute() Material material) {
        materialService.saveMaterial(material);
        return "redirect:/getMaterial";
    }

    @GetMapping("/updateMaterial/{id}")
    public String updateMaterial(@PathVariable int id, Model model) {
        model.addAttribute("material", materialService.getMaterialId(id));
        return "/Update_Material";
    }

    @PostMapping("/updateMaterial/{id}")
    public String updateMaterialMeth(@PathVariable int id, @ModelAttribute("material") Material material, Model model) {
        Material existingMaterial = materialService.getMaterialId(id);
        existingMaterial.setId(id);
        existingMaterial.setName(material.getName());
        existingMaterial.setQty(material.getQty());
        existingMaterial.setUnit(material.getUnit());

        materialService.updateMaterial(existingMaterial);

        return "redirect:/getMaterial";
    }

    @GetMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable int id) {
        materialService.deleteMaterialById(id);
        return "redirect:/getMaterial";
    }

    @GetMapping("/siteIncharge")
    public String siteInchargeMeth(Model model) {
        model.addAttribute("req_material", request_service.getAllMaterial());
        return "Site_Incharge";
    }

    @GetMapping("/user")
    public String siteInchargeMeth2(Model model) {
        model.addAttribute("req_material", request_service.getAllMaterial());
        return "View_Material";
    }

    @GetMapping("/addRequestedMaterial")
    public String addMaterialRequest(Model model) {
        Requested_Material requestedMaterial = new Requested_Material();
        model.addAttribute("newMaterial", requestedMaterial);
        return "Add_Requested_Material";
    }

    @PostMapping("/saveRequestedMaterial")
    public String saveRequestedMaterial(@ModelAttribute() Requested_Material material) {
        request_service.saveMaterial(material);
        return "redirect:/siteIncharge";
    }




}
