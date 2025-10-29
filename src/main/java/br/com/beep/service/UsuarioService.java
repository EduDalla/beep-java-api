package br.com.beep.service;

import br.com.beep.exception.NotFoundException;
import br.com.beep.model.Usuario;
import br.com.beep.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo){ this.repo=repo; }

    public List<Usuario> findAll(){ return repo.findAll(); }
    public Usuario findById(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado")); }
    public Usuario create(Usuario u){ return repo.save(u); }
    public Usuario update(Long id, Usuario u){
        Usuario cur = findById(id);
        cur.setNome(u.getNome());
        cur.setDataNascimento(u.getDataNascimento());
        return repo.save(cur);
    }
    public void delete(Long id){
        if (!repo.existsById(id)) throw new NotFoundException("Usuario não encontrado");
        repo.deleteById(id);
    }
}
