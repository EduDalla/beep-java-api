package br.com.beep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.beep.model.Beep;
public interface BeepRepository extends JpaRepository<Beep, Long> {
}
