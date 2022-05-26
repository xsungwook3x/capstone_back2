package com.example.server2.repository;

import com.example.server2.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepostiory extends JpaRepository<EventEntity,Long> {

    List<EventEntity> findByTownId(Long townId);
}
