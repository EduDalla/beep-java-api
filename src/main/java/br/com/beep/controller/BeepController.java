package br.com.beep.controller;

import br.com.beep.model.Beep;
import br.com.beep.service.BeepService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/beeps")
public class BeepController {
    private final BeepService service;
    public BeepController(BeepService service){ this.service=service; }

    @GetMapping public List<Beep> list(){ return service.findAll(); }
    @GetMapping("/{id}") public Beep get(@PathVariable("id") Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Beep create(@RequestBody Beep b){ return service.create(b); }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Beep registrar(@RequestBody Map<String, Long> payload){
        Long usuarioId = payload.get("usuarioId");
        Long produtoId = payload.get("produtoId");
        return service.registrar(usuarioId, produtoId);
    }
}
