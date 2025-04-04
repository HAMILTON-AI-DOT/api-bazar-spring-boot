package com.tienda.bazar.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Entity
@Getter @Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fecha_venta;
    private Double total;


    // Relación de muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente unCliente;


    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente, List<Producto> productos) {
        this.codigo = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.unCliente = unCliente;
        this.productos = productos;
    }


}
