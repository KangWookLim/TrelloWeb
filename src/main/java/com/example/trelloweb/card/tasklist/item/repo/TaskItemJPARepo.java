package com.example.trelloweb.card.tasklist.item.repo;

import com.example.trelloweb.card.tasklist.item.entity.TaskitemVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemJPARepo extends JpaRepository<TaskitemVO, Long> {

}
