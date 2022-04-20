package com.quatrain.Quatrain.models.repositories;

import com.quatrain.Quatrain.models.Noticia;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {
    @Modifying @Transactional
    @Query(value="insert into noticias (noticia_titulo, noticia_descricao, noticia_data)"+
        " values(:#{#Noticia.titulo}, :#{#Noticia.descricao}, :#{#Noticia.data})", nativeQuery=true)
    Integer createNoticia(@Param("Noticia") Noticia noticia);
}
