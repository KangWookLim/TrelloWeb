package com.example.trelloweb.workspace.Base.Repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WSRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;



}