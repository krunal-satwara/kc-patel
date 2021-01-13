package com.krunal.kcpatel.serviceImpl;

import com.krunal.kcpatel.entity.Writes;
import com.krunal.kcpatel.repository.WritesRepository;
import com.krunal.kcpatel.service.WritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WritesServiceImpl implements WritesService {

    @Autowired
    private WritesRepository writesRepository;

    @Override
    public ResponseEntity<String> saveWrites(Writes writes) {
        try {
            writesRepository.save(writes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteWrites(Long writesId) {
        try {
            Writes writes = writesRepository.findByWritesId(writesId);
            writes.setStatus(true);
            writesRepository.save(writes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Writes getWrites(Long writesId) {
        try {
            return writesRepository.findByWritesId(writesId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Writes> writes() {
        try {
            return writesRepository.findAllByStatusIsFalse();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
