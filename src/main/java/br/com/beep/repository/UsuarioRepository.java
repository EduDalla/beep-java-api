package br.com.beep.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.beep.model.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
