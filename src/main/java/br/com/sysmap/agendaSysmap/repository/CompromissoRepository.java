package br.com.sysmap.agendaSysmap.repository;

import br.com.sysmap.agendaSysmap.model.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

    @Query(value = "SELECT c from Compromisso c WHERE c.usuario.id = :userId")
    List<Compromisso> findCompromissoPorUsuario(@Param("userId") Long userId);

}
