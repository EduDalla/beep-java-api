package br.com.beep.service;

import br.com.beep.exception.BusinessException;
import br.com.beep.exception.NotFoundException;
import br.com.beep.model.UsuarioRegra;
import br.com.beep.model.Usuario;
import br.com.beep.model.Regra;
import br.com.beep.repository.UsuarioRegraRepository;
import br.com.beep.repository.UsuarioRepository;
import br.com.beep.repository.RegraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioRegraService {
    private final UsuarioRegraRepository repo;
    private final UsuarioRepository usuarioRepo;
    private final RegraRepository regraRepo;

    public UsuarioRegraService(UsuarioRegraRepository repo, UsuarioRepository usuarioRepo, RegraRepository regraRepo){
        this.repo=repo; this.usuarioRepo=usuarioRepo; this.regraRepo=regraRepo;
    }

    public List<UsuarioRegra> findAll(){ return repo.findAll(); }
    public UsuarioRegra findById(Long id){ return repo.findById(id).orElseThrow(() -> new NotFoundException("Usuário-Regra não encontrado")); }
    public UsuarioRegra create(UsuarioRegra ur){
        Usuario u = usuarioRepo.findById(ur.getUsuario().getId()).orElseThrow(() -> new BusinessException("Usuario inexistente"));
        Regra r = regraRepo.findById(ur.getRegra().getId()).orElseThrow(() -> new BusinessException("Regra inexistente"));
        ur.setUsuario(u); ur.setRegra(r);
        return repo.save(ur);
    }

    public UsuarioRegra update(Long id, UsuarioRegra ur) {
        UsuarioRegra atual = findById(id);

        if (ur.getUsuario() != null && ur.getUsuario().getId() != null) {
            atual.setUsuario(
                    usuarioRepo.findById(ur.getUsuario().getId())
                            .orElseThrow(() -> new BusinessException("Usuário inexistente"))
            );
        }

        if (ur.getRegra() != null && ur.getRegra().getId() != null) {
            atual.setRegra(
                    regraRepo.findById(ur.getRegra().getId())
                            .orElseThrow(() -> new BusinessException("Regra inexistente"))
            );
        }

        return repo.save(atual);
    }

    public void delete(Long id){
        if (!repo.existsById(id)) throw new NotFoundException("Usuário-Regra não encontrado");
        repo.deleteById(id);
    }
}
