package com.quatrain.Quatrain.controllers;

import java.util.Optional;
import com.quatrain.Quatrain.models.Role;
import com.quatrain.Quatrain.models.exceptions.NotFoundException;
import com.quatrain.Quatrain.models.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    
   @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
   public Iterable<Role>getNoticias() {
       return roleRepository.findAll();
   }

   @GetMapping(path = "/{id:[0-2]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Role getRole(@PathVariable int id) {
        Optional<Role> _role = roleRepository.findById(id);
        if (!_role.isPresent()) throw
                new NotFoundException("" + id, "role", "id");
        else
            return _role.get();
    }
}
