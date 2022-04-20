package com.quatrain.Quatrain.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.geo.Point;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="evento_id")private int id;
    @Column(name="evento_titulo")private String titulo;
    @Column(name="evento_descricao")private String descricao;
    @Column(name="evento_data")private LocalDate data;
    @Column(name="evento_image")private String image;
    @Column(name="evento_local")private Point local;
  
    public Evento(){}
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public String getImage() {
        return image;
    }

    public Point getLocal() {
        return local;
    }
}
