package com.quatrain.Quatrain.models.repositories;

import com.quatrain.Quatrain.models.Evento;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EventoRepository extends CrudRepository<Evento, Integer>{
    @Modifying @Transactional
    @Query(value="insert into eventos (evento_titulo, evento_descricao, evento_data, evento_image, evento_local)"+
        " values(:#{#Evento.titulo}, :#{#Evento.descricao}, :#{#Evento.data}, :#{#Evento.image}, :#{#Evento.local})", nativeQuery=true)
    Integer createEvento(@Param("Evento") Evento evento);
}
