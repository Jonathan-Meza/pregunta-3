package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Producto {
    private String nombre;
    private Double precioNormal;
    private Double precioMayor;
}
