package com.example.trelloweb.card.repo;

import com.example.trelloweb.card.base.vo.CardVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardDetailRepo extends JpaRepository<CardVo, Long> {




}
