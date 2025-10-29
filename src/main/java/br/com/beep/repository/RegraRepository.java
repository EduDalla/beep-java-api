package br.com.beep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.beep.model.Regra;
public interface RegraRepository extends JpaRepository<Regra, Long> {
}
