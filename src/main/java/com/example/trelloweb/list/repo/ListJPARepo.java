package com.example.trelloweb.list.repo;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.list.entity.ListVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface ListJPARepo extends JpaRepository<ListVo, Long> {
}
