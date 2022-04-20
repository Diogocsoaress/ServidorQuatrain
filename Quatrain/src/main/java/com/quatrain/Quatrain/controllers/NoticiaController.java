package com.quatrain.Quatrain.controllers;

import java.util.Optional;

import com.quatrain.Quatrain.models.Noticia;
import com.quatrain.Quatrain.models.exceptions.NotFoundException;
import com.quatrain.Quatrain.models.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/noticias")
public class NoticiaController {
    @Autowired
    private NoticiaRepository noticiaRepository;
    
   @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
   public Iterable<Noticia>getNoticias() {
       return noticiaRepository.findAll();
   }

   @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Noticia getNoticia(@PathVariable int id) {
        Optional<Noticia> _noticia = noticiaRepository.findById(id);
        if (!_noticia.isPresent()) throw
                new NotFoundException("" + id, "noticia", "id");
        else
            return _noticia.get();
    }
}
