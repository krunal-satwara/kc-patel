package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Agent;
import com.krunal.kcpatel.entity.UserAgent;
import com.krunal.kcpatel.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/save")
    ResponseEntity<String> saveAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateAgent(@RequestBody Agent agent) {
        return agentService.updateAgent(agent);
    }

    @DeleteMapping("/delete/{agentId}")
    ResponseEntity<String> deleteAgent(@PathVariable("agentId") Long agentId) {
        return agentService.deleteAgent(agentId);
    }

    @GetMapping("/agentList")
    List<Agent> agentList() {
        return agentService.agentList();
    }

    @PostMapping("/saveUserAgentList/{userId}")
    public ResponseEntity<String> saveUserAgentList(@RequestBody List<UserAgent> userAgents, @PathVariable("userId") Long userId) {
        return agentService.saveUserAgentList(userId, userAgents);
    }

    @GetMapping("/savedAgentListForUser/{userId}")
    List<UserAgent> savedAgentListForUser(@PathVariable("userId") Long userId) {
        return agentService.savedAgentListForUser(userId);
    }

    @GetMapping("/filteredUserAgentList/{userId}")
    List<Agent> filteredUserAgentList(@PathVariable("userId") Long userId) {
        return agentService.filteredUserAgentList(userId);
    }

    @GetMapping("/agentCodeExist/{agentCode}")
    Object agentCodeExist(@PathVariable("agentCode") String agentCode) {
        return agentService.agentCodeExist(agentCode);
    }
}
