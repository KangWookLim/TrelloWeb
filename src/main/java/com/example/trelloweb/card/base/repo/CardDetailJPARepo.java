package com.example.trelloweb.card.base.repo;

import com.example.trelloweb.card.base.vo.CardVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailJPARepo extends JpaRepository<CardVo, Long> {




}
