package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findByAgentId(Long agentId);

    Agent findByAgentCode(String agentCode);
}
