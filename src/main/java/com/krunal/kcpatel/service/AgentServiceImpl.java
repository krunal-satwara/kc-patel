package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Agent;
import com.krunal.kcpatel.entity.User;
import com.krunal.kcpatel.entity.UserAgent;
import com.krunal.kcpatel.repository.AgentRepository;
import com.krunal.kcpatel.repository.UserAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserAgentRepository userAgentRepository;

    @Override
    public ResponseEntity<String> saveAgent(Agent agent) {
        try {
            agentRepository.save(agent);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateAgent(Agent agent) {
        try {
            agentRepository.save(agent);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteAgent(Long agentId) {
        try {
            Agent agent = agentRepository.findByAgentId(agentId);
            agentRepository.delete(agent);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<Agent> agentList() {
        try {
            return agentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserAgent> userAgentList() {
        try {
            return userAgentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Agent> filteredUserAgentList(Long userId) {
        try {
            List<Agent> userAgentList = agentList();
            List<UserAgent> savedAgentList = savedAgentListForUser(userId);
            List<Agent> filteredUserAgentList = new ArrayList<>();
            filteredUserAgentList.addAll(userAgentList);
            for (UserAgent userAgent:savedAgentList) {
                Agent agent = new Agent();
                agent.setAgentId(userAgent.getAgentId());
                agent.setAgentCode(userAgent.getAgentCode());
                for (Agent agent1: userAgentList) {
                    if(agent.getAgentId().equals(agent1.getAgentId())){
                        filteredUserAgentList.remove(agent);
                    }
                }
            }
            return filteredUserAgentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<String> saveUserAgentList(Long userId, List<UserAgent> userAgents) {
        List<UserAgent> userAgentList = userAgentRepository.findAllByUserId(userId);
        if(userAgentList!=null) {
            for (UserAgent userAgent : userAgentList) {
                userAgentRepository.delete(userAgent);
            }
        }
        try {
            for (UserAgent userAgent:userAgents) {
                userAgentRepository.save(userAgent);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<UserAgent> savedAgentListForUser(Long userId) {
        try {
            return userAgentRepository.findAllByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object agentCodeExist(String agentCode) {
        try {
            Agent agent = agentRepository.findByAgentCode(agentCode);
            if (agent != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
