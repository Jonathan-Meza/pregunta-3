package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class Venta {
    List<DetalleVenta> detalleVenta;
    private Double total;
    private LocalDate fechaVenta;
}
