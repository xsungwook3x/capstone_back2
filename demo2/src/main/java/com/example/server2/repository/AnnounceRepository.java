package com.example.server2.repository;

import com.example.server2.model.AnnounceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceRepository extends JpaRepository<AnnounceEntity,Long> {

}
