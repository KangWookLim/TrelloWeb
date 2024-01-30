package com.example.trelloweb.card.tasklist.item.service;

import com.example.trelloweb.card.tasklist.item.repo.TaskItemRepo;
import com.example.trelloweb.card.tasklist.item.vo.TaskItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskItemService {
    private final TaskItemRepo taskItemRepo;
    public List<TaskItems> getTaskItems(Long taskid) {
        return taskItemRepo.getTaskItems(taskid);
    }
}
