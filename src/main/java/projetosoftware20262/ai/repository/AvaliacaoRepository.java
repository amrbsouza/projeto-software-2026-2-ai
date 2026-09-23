package projetosoftware20262.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetosoftware20262.ai.entity.Avaliacao;

@Repository 
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
