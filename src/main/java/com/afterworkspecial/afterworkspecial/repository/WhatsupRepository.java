package com.afterworkspecial.afterworkspecial.repository;

import com.afterworkspecial.afterworkspecial.domain.Whatsup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatsupRepository extends JpaRepository<Whatsup, Long> {
}
