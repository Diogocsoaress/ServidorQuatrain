package com.quatrain.Quatrain.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="noticia_id")private int id;
    @Column(name="noticia_titulo")private String titulo;
    @Column(name="noticia_descricao")private String descricao;
    @Column(name="noticia_data")private LocalDate data;
    @Column(name="noticia_image")private String image;
  
    public Noticia(){}
    
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
}