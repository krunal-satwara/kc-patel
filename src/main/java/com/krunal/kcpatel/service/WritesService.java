package com.krunal.kcpatel.service;

import com.krunal.kcpatel.entity.Role;
import com.krunal.kcpatel.entity.Writes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WritesService {

    ResponseEntity<String> saveWrites(Writes writes);

    ResponseEntity<String> deleteWrites(Long writesId);

    Writes getWrites(Long writesId);

    List<Writes> writes();
}
