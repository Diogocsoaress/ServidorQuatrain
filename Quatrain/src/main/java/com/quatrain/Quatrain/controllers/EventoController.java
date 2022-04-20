package com.quatrain.Quatrain.controllers;

import java.util.Optional;

import com.quatrain.Quatrain.models.Evento;
import com.quatrain.Quatrain.models.exceptions.NotFoundException;
import com.quatrain.Quatrain.models.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/eventos")
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;
    
   @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
   public Iterable<Evento>getEventos() {
       return eventoRepository.findAll();
   }

   @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento getEvento(@PathVariable int id) {
        Optional<Evento> _evento = eventoRepository.findById(id);
        if (!_evento.isPresent()) throw
                new NotFoundException("" + id, "noticia", "id");
        else
            return _evento.get();
    }
}
