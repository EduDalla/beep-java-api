package br.com.beep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.beep.model.Produto;
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
