package com.example.trelloweb.card.tasklist.item.service;

import com.example.trelloweb.card.tasklist.base.entity.CardTaskVo;
import com.example.trelloweb.card.tasklist.base.repo.CardTaskJpaRepo;
import com.example.trelloweb.card.tasklist.item.entity.TaskitemVO;
import com.example.trelloweb.card.tasklist.item.repo.TaskItemJPARepo;
import com.example.trelloweb.card.tasklist.item.repo.TaskItemRepo;
import com.example.trelloweb.card.tasklist.item.vo.TaskItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskItemService {
    private final TaskItemRepo taskItemRepo;
    private final TaskItemJPARepo taskItemJPARepo;
    private final CardTaskJpaRepo cardTaskJpaRepo;
    public List<TaskItems> getTaskItems(Long taskid) {
        return taskItemRepo.getTaskItems(taskid);
    }

    public void addItemtoTask(Long taskId, String title) {
        CardTaskVo cardTaskVo = cardTaskJpaRepo.findById(taskId).orElse(null);
        TaskitemVO taskitemVO = new TaskitemVO();
        taskitemVO.setCardtaskvo(cardTaskVo);
        taskitemVO.setTitle(title);
        taskitemVO.setChecked(false);
        taskItemJPARepo.save(taskitemVO);
    }

    public int task_items_percent(Long taskId) {
        return taskItemRepo.getPercentage(taskId);
    }

    public void setTaskItem(Long taskItemId, Boolean checked) {
        TaskitemVO taskitemVO = taskItemJPARepo.findById(taskItemId).orElse(null);
        taskitemVO.setChecked(checked);
        taskItemJPARepo.save(taskitemVO);
    }

    public void deleteTaskItem(Long taskItemId) {
        taskItemJPARepo.deleteById(taskItemId);
    }
}
