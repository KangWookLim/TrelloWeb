package com.example.trelloweb.card.comment.repo;

import com.example.trelloweb.card.comment.entity.CardCommentVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCommentJPARepo extends JpaRepository<CardCommentVo, Long> {

}
