package com.example.trelloweb.list.service;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.Base.repo.BoardJpaRepo;
import com.example.trelloweb.list.entity.ListVo;
import com.example.trelloweb.list.repo.ListJPARepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ListJPARepo listJPARepo;
    private final BoardJpaRepo boardJpaRepo;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public int getMaxListOrder(Long boardId) {
        String sql = "Select max(list_order) from list where board_id = :board_id";
        Map<String, Long> params = Map.of("board_id",boardId);
        try{
            return jdbcTemplate.queryForObject(sql, params, int.class);
        }catch (NullPointerException e){
            return 0;
        }
    }
    public void addList(Long boardId, String listName, Integer order) {
        BoardVo boardVo = boardJpaRepo.findById(boardId).orElse(null);
        ListVo listVo = new ListVo();
        listVo.setBoardvo(boardVo);
        listVo.setName(listName);
        listVo.setListorder(order);
        listJPARepo.save(listVo);
    }

    public void reorderList(Long listId, Integer order) {
        ListVo listVo = listJPARepo.findById(listId).orElse(null);
        listVo.setListorder(order);
        listJPARepo.save(listVo);
    }
    public void removeList(Long listId){
        listJPARepo.deleteById(listId);
    }

    public void editListTitle(String title, Long listId) {
        ListVo listVo = listJPARepo.findById(listId).orElse(null);
        listVo.setName(title);
        listJPARepo.save(listVo);
    }
}
