package com.example.demo.app;

import com.example.demo.model.DetalleVenta;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.service.VentaServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
class Command implements CommandLineRunner {

    @Autowired
    private VentaServiceImpl service;

    @Override
    public void run(String... args) throws Exception {
        List<Producto> productos = this.cargarProductos();

        //Configuro la venta que realizare
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        detalleVentas.add(DetalleVenta.builder().cantidad(1).producto(productos.get(0)).build());
        detalleVentas.add(DetalleVenta.builder().cantidad(1).producto(productos.get(1)).build());
        detalleVentas.add(DetalleVenta.builder().cantidad(1).producto(productos.get(2)).build());

        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        venta.setDetalleVenta(detalleVentas);

        service.procesarVenta(venta);
        this.mostrarTotalVenta(venta);


    }

    private void mostrarTotalVenta(Venta venta) {
        log.info("Detalle de Ventas");
        log.info("------------------");
        venta.getDetalleVenta().stream().forEach(d -> {
            log.info("Usted compro {} producto(s) {} a {} : Subtotal: {}",d.getCantidad(), d.getProducto().getNombre(), d.getPrecio(), d.getSubtotal());
        });
        log.info("------------------");
        log.info("Total: {}", venta.getTotal());
        log.info("Fecha Venta: {}", venta.getFechaVenta());

    }

    private List<Producto> cargarProductos() {
        Producto[] productos = {
                new Producto("A", 6.00, 5.50),
                new Producto("B", 8.50, 7.90),
                new Producto("C", 13.2, 11.60)
        };

        return Arrays.asList(productos);
    }

}
