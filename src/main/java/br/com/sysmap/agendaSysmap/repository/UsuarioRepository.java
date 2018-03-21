package br.com.sysmap.agendaSysmap.repository;

import br.com.sysmap.agendaSysmap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
