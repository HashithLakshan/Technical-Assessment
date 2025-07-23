package com.example.backEnd.repository;

import com.example.backEnd.constant.CommonStatus;
import com.example.backEnd.constant.TaskStatus;
import com.example.backEnd.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task getByTaskId(Long aLong);

    Page<Task> findByCommonStatus(CommonStatus commonStatusEnum, Pageable pageable);

    Page<Task> findByCommonStatusAndTaskStatus(CommonStatus commonStatusEnum, TaskStatus taskStatusEnum, Pageable pageable);
}
