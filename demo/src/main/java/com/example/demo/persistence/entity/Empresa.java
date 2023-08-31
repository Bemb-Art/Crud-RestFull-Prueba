package com.example.demo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "nit")
    String nit;
    @Column(name = "fechaFundacion")
    Date fechaFundacion;
    @Column(name = "direccion")
    String direccion;

    @Override
    public String toString() {
        return "empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}
