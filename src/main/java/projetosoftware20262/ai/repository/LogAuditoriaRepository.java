package projetosoftware20262.ai.repository;

import org.springframework.stereotype.Repository;

import projetosoftware20262.ai.entity.LogAuditoria;

@Repository 
public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Long> {
}