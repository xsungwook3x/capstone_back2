package com.example.server2.repository;

import com.example.server2.model.TerminalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalEntity,Long> {

    List<TerminalEntity> findByPhone(String phone);
}
