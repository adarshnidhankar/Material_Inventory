package com.Spring_Boot.Material_Inventory.controller;

import com.Spring_Boot.Material_Inventory.model.Available_Material;
import com.Spring_Boot.Material_Inventory.model.Material;
import com.Spring_Boot.Material_Inventory.model.Requested_Material;
import com.Spring_Boot.Material_Inventory.service.Available_Material_Service;
import com.Spring_Boot.Material_Inventory.service.Material_Request_Service;
import com.Spring_Boot.Material_Inventory.service.Material_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main_Controller {
    @Autowired
    Material_Service materialService;

    @Autowired
    Material_Request_Service request_service;

    @Autowired
    private Available_Material_Service availableMaterialService;

    public Main_Controller(Material_Service materialService) {
        super();
        this.materialService = materialService;
    }

//when we run the project, it will go to landing page.
    @GetMapping("/")
    public String landingPage() {
        return "Home_Page";
    }

    //this api will fetch all the material list in the database.
    @GetMapping("/getMaterial")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String materialList(Model model) {
        model.addAttribute("materials", materialService.getAllMaterial());
        return "/Store_Incharge";
    }

    // this api will use to open the add material form.
    @GetMapping("/addMaterial")
    public String addMaterial(Model model) {
        Material material = new Material();
        model.addAttribute("newMaterial", material);
        return "/Add_Material";
    }

    // this api will use to save the material entered by user in the form into the database.
    @PostMapping("/saveMaterial")
    public String saveMaterial(@ModelAttribute() Material material) {
        materialService.saveMaterial(material);
        return "redirect:/getMaterial";
    }

    //this api will accept the updated value from the user.
    @GetMapping("/updateMaterial/{id}")
    public String updateMaterial(@PathVariable int id, Model model) {
        model.addAttribute("material", materialService.getMaterialId(id));
        return "/Update_Material";
    }

    // this api will use to save the updated values into the databases.
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

    // this api will use to delete the specified material by id.
    @GetMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable int id) {
        materialService.deleteMaterialById(id);
        return "redirect:/getMaterial";
    }

    // this api will use to fetch the all the material requested by the site in-charge.
    @GetMapping("/siteIncharge")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String siteInchargeMeth(Model model) {
        model.addAttribute("req_material", request_service.getAllMaterial());
        return "Site_Incharge";
    }

    // this api is used to only display all the material requested by the site in-charge to the store in-charge.
    @GetMapping("/user")
    public String siteInchargeMeth2(Model model) {
        model.addAttribute("req_material", request_service.getAllMaterial());
        return "View_Material";
    }


    // this api is used add requested material by site in-charge.
    @GetMapping("/addRequestedMaterial")
    public String addMaterialRequest(Model model) {
        Requested_Material requestedMaterial = new Requested_Material();
        model.addAttribute("newMaterial", requestedMaterial);
        return "Add_Requested_Material";
    }
    // this is used to save the requested material into the table.
    @PostMapping("/saveRequestedMaterial")
    public String saveRequestedMaterial(@ModelAttribute() Requested_Material material) {
        request_service.saveMaterial(material);
        return "redirect:/avaMaterial";
    }

    //this api is used to fetch all the available material in table.
    @GetMapping("/avaMaterial")
    public String availableMaterial(Model model) {
        model.addAttribute("ava_material", availableMaterialService.getAllMaterial());
        return "Available_Material";
    }

    //delete material from available material table.
    @GetMapping("/deleteAvailableMaterial/{id}")
    public String deleteAvailableMaterial(@PathVariable int id) {
        availableMaterialService.deleteAvailableMaterialById(id);
        return "redirect:/avaMaterial";
    }

    //delete material from the requested material table.
    @GetMapping("/deleteRequestedMaterial/{id}")
    public String deleteRequestedMaterial(@PathVariable int id) {
        request_service.deleteRequestedMaterial(id);
        return "redirect:/user";
    }

    //this is used to redirect the user signup page.
    @GetMapping("/signup")
    public String signupPage(){
        return "/User_Signup";
    }


}
