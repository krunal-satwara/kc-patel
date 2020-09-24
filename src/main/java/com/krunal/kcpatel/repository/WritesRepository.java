package com.krunal.kcpatel.repository;

import com.krunal.kcpatel.entity.Writes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WritesRepository extends JpaRepository<Writes,Long> {

    Writes findByWritesId(Long writesId);

    List<Writes> findAllByStatusIsFalse();

}
