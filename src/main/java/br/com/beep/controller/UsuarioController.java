package br.com.beep.controller;

import br.com.beep.model.Usuario;
import br.com.beep.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service){ this.service=service; }

    @GetMapping public List<Usuario> list(){ return service.findAll(); }
    @GetMapping("/{id}") public Usuario get(@PathVariable("id") Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Usuario create(@Valid @RequestBody Usuario body){ return service.create(body); }
    @PutMapping("/{id}") public Usuario update(@PathVariable("id") Long id, @Valid @RequestBody Usuario body){ return service.update(id, body); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){ service.delete(id); }
}
