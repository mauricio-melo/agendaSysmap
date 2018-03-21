package br.com.sysmap.agendaSysmap.repository;

import br.com.sysmap.agendaSysmap.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
