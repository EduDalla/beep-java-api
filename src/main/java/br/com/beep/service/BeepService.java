package br.com.beep.service;

import br.com.beep.exception.BusinessException;
import br.com.beep.exception.NotFoundException;
import br.com.beep.model.Beep;
import br.com.beep.model.BeepStatus;
import br.com.beep.model.Produto;
import br.com.beep.model.Usuario;
import br.com.beep.repository.BeepRepository;
import br.com.beep.repository.ProdutoRepository;
import br.com.beep.repository.UsuarioRepository;
import jakarta.persistence.OptimisticLockException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BeepService {
    private final BeepRepository repo;
    private final UsuarioRepository usuarioRepo;
    private final ProdutoRepository produtoRepo;

    public BeepService(BeepRepository repo, UsuarioRepository usuarioRepo, ProdutoRepository produtoRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
        this.produtoRepo = produtoRepo;
    }

    public List<Beep> findAll() {
        return repo.findAll();
    }

    public Beep findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Beep não encontrado"));
    }

    public Beep create(Beep b) {
        return repo.save(b);
    }

    @Transactional
    public Beep registrar(Long usuarioId, Long produtoId) {
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow(() -> new BusinessException("Usuario inexistente"));
        Produto p = produtoRepo.findById(produtoId).orElseThrow(() -> new BusinessException("Produto inexistente"));

        try {
            if (p.getQuantidadeEstoque() <= 0) {
                Beep b = new Beep();
                b.setUsuario(u);
                b.setProduto(p);
                b.setStatus(BeepStatus.ERRO_ESTOQUE);
                return repo.save(b);
            }
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - 1);
            produtoRepo.save(p);
            Beep b = new Beep();
            b.setUsuario(u);
            b.setProduto(p);
            b.setStatus(BeepStatus.OK);
            return repo.save(b);
        } catch (OptimisticLockingFailureException | OptimisticLockException ex) {
            throw new BusinessException("Conflito ao atualizar estoque, tente novamente");
        }
    }
}
