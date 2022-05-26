package com.example.server2.repository;

import com.example.server2.model.TerminalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalInfoRepository extends JpaRepository<TerminalInfoEntity,Long> {

}
