package br.com.beep.service;

import br.com.beep.exception.NotFoundException;
import br.com.beep.model.Regra;
import br.com.beep.repository.RegraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegraService {
    private final RegraRepository repo;
    public RegraService(RegraRepository repo){ this.repo=repo; }
    public List<Regra> findAll(){ return repo.findAll(); }
    public Regra findById(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("Regra não encontrada")); }
    public Regra create(Regra r){ return repo.save(r); }
    public Regra update(Long id, Regra r){
        Regra cur = findById(id);
        cur.setNomeRegra(r.getNomeRegra());
        return repo.save(cur);
    }
    public void delete(Long id){
        if (!repo.existsById(id)) throw new NotFoundException("Regra não encontrada");
        repo.deleteById(id);
    }
}
