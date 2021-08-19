package com.example.demo.service;

import com.example.demo.model.DetalleVenta;
import com.example.demo.model.Venta;
import org.springframework.stereotype.Service;


@Service
public class VentaServiceImpl implements VentaService {

    @Override
    public void procesarVenta(Venta venta) {
        Integer cantidadProductos = venta.getDetalleVenta().stream().map(DetalleVenta::getCantidad).reduce(0,Integer::sum);
        venta.getDetalleVenta().stream().forEach(detalle->{
            //Al por mayor o menor
            detalle.setPrecio(cantidadProductos<6?
                    detalle.getProducto().getPrecioNormal():
                    detalle.getProducto().getPrecioMayor());
            detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecio());
        });

        venta.setTotal(venta.getDetalleVenta().stream().map(DetalleVenta::getSubtotal).reduce(0.0,Double::sum));

    }

}
