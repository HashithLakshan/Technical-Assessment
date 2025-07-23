package com.example.backEnd.service;

import com.example.backEnd.dto.TaskDto;
import com.example.backEnd.utill.CommonResponse;

public interface TaskService {
    CommonResponse save(TaskDto taskDto);

    CommonResponse getFilteredTasks(String commonStatus, String taskStatus, int page, int size);

    CommonResponse updateStatus(String taskId, String status);
}
