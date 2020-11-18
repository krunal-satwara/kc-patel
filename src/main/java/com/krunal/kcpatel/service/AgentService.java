package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Agent;
import com.krunal.kcpatel.entity.UserAgent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgentService {
    ResponseEntity<String> saveAgent(Agent agent);

    ResponseEntity<String> updateAgent(Agent agent);

    ResponseEntity<String> deleteAgent(Long agentId);

    List<Agent> agentList();

    List<UserAgent> userAgentList();

    List<Agent> filteredUserAgentList(Long userId);

    ResponseEntity<String> saveUserAgentList(Long userId,List<UserAgent> userAgents);

    List<UserAgent> savedAgentListForUser(Long userId);

    Object agentCodeExist(String agentCode);
}
