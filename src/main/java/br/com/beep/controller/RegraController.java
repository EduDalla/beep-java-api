package br.com.beep.controller;

import br.com.beep.model.Regra;
import br.com.beep.service.RegraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/regras")
public class RegraController {
    private final RegraService service;
    public RegraController(RegraService service){ this.service=service; }

    @GetMapping public List<Regra> list(){ return service.findAll(); }
    @GetMapping("/{id}") public Regra get(@PathVariable("id") Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Regra create(@Valid @RequestBody Regra body){ return service.create(body); }
    @PutMapping("/{id}") public Regra update(@PathVariable("id") Long id, @Valid @RequestBody Regra body){ return service.update(id, body); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){ service.delete(id); }
}
