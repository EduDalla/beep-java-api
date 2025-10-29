package br.com.beep.controller;

import br.com.beep.model.UsuarioRegra;
import br.com.beep.service.UsuarioRegraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios-regras")
public class UsuarioRegraController {
    private final UsuarioRegraService service;
    public UsuarioRegraController(UsuarioRegraService service){ this.service=service; }

    @GetMapping public List<UsuarioRegra> list(){ return service.findAll(); }
    @GetMapping("/{id}") public UsuarioRegra get(@PathVariable("id") Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public UsuarioRegra create(@Valid @RequestBody UsuarioRegra body){ return service.create(body); }
    @PutMapping("/{id}") public UsuarioRegra update(@PathVariable("id") Long id, @Valid @RequestBody UsuarioRegra body){ return service.update(id, body); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){ service.delete(id); }
}
