package br.com.sysmap.agendaSysmap.repository;

import br.com.sysmap.agendaSysmap.model.Perfil;
import br.com.sysmap.agendaSysmap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u from Usuario u WHERE u.perfil = :perfil")
    List<Usuario> findUsuariosPorPerfil(@Param("perfil") Perfil perfil);

}
