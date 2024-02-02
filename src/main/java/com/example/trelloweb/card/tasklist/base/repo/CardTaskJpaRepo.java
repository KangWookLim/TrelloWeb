package com.example.trelloweb.card.tasklist.base.repo;

import com.example.trelloweb.card.tasklist.base.entity.CardTaskVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTaskJpaRepo extends JpaRepository<CardTaskVo, Long> {

}
