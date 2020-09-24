package com.krunal.kcpatel.controller;

import com.krunal.kcpatel.entity.Writes;
import com.krunal.kcpatel.service.WritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writes")
public class WritesController {

    @Autowired
    private WritesService writesService;

    @PostMapping("/save")
    public ResponseEntity<String> saveWrites(Writes writes) {
        return writesService.saveWrites(writes);
    }

    @GetMapping("/{writesId}")
    public Writes getWrites(Long writesId) {
        return writesService.getWrites(writesId);
    }

    @DeleteMapping("/{writesId}")
    public ResponseEntity<String> deleteWrites(Long writesId) {
        return writesService.deleteWrites(writesId);
    }

    @GetMapping("/writes")
    public List<Writes> writes() {
        return writesService.writes();
    }

}
