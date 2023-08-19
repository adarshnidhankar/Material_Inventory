package com.Spring_Boot.Material_Inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "material_request")
public class Requested_Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int qty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id_ref")
    private Material material;

}
