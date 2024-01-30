package com.example.trelloweb.list.service;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.list.entity.ListVo;
import com.example.trelloweb.list.repo.ListJPARepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ListJPARepo listJPARepo;
}
