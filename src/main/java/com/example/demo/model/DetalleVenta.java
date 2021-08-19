package com.example.demo.model;

import lombok.*;


@Getter @Setter @Builder
public class DetalleVenta {
    private Producto producto;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;
}
