package br.com.sysmap.agendaSysmap.repository;

import br.com.sysmap.agendaSysmap.model.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

    @Query(value = "SELECT c from Compromisso c WHERE c.usuario.id = :idUsuario")
    List<Compromisso> findCompromissoPorUsuario(@Param("idUsuario") Long idUsuario);


    @Query(value = "SELECT c from Compromisso c " +
            " INNER JOIN Usuario u " +
            " ON c.usuario.id = u.id "+
            " INNER JOIN Equipe e " +
            " ON u.equipe.id = e.id " +
            " WHERE u.equipe.id = :equipeId")
    List<Compromisso> findCompromissoPorEquipe(@Param("equipeId") Long equipeId);


}
