package com.example.backEnd.service.serviceImpl;

import com.example.backEnd.constant.CommonStatus;
import com.example.backEnd.constant.TaskStatus;
import com.example.backEnd.dto.TaskDto;
import com.example.backEnd.entity.Task;
import com.example.backEnd.repository.TaskRepository;
import com.example.backEnd.service.TaskService;
import com.example.backEnd.utill.CommonResponse;
import com.example.backEnd.utill.CommonValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);


    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public CommonResponse save(TaskDto taskDto) {
        CommonResponse commonResponse = new CommonResponse();

        List<String> validationList = this.TaskValidation(taskDto);
        if (!validationList.isEmpty()) {
            commonResponse.setErrorMessages(validationList);
            return commonResponse;
        }
        if(CommonValidation.validateTaskTitle(taskDto.getTaskTitle())) {
            commonResponse.setStatus(false);
            commonResponse.setCommonMessage("Title must be between 3 and 25 characters");
            return commonResponse;
        }

        if (CommonValidation.validateTaskDiscription(taskDto.getTaskDiscription())) {
            commonResponse.setStatus(false);
            commonResponse.setCommonMessage("Discription must be between 3 and 100 characters");
            return commonResponse;
        }
try {
    Task task = taskRepository.getByTaskId(Long.valueOf(taskDto.getTaskId()));
    if (task != null) {
        commonResponse.setStatus(false);
        commonResponse.setCommonMessage("Task already arranged");
        return commonResponse;
    } else {
        Task newTask = new Task();
        newTask.setTaskId(Long.valueOf(taskDto.getTaskId()));
        newTask.setTaskTitle(taskDto.getTaskTitle());
        newTask.setTaskDiscription(taskDto.getTaskDiscription());
        newTask.setCommonStatus(CommonStatus.ACTIVE);
        newTask.setTaskStatus(TaskStatus.ASSIGNED);
        taskRepository.save(newTask);
        commonResponse.setStatus(true);
        commonResponse.setCommonMessage("Successfully arranged task");
        return commonResponse;
    }
} catch (Exception e) {
    commonResponse.setStatus(false);
    LOGGER.error("/**************** Exception in TaskService -> save()" + e);
}
return commonResponse;
    }

    @Override
    public CommonResponse getFilteredTasks(String commonStatus, String taskStatus, int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));
        List<TaskDto> taskDtoList = new ArrayList<>();
        Page<Task> taskPage;

        try {

            // Convert String to Enum
            CommonStatus commonStatusEnum = CommonStatus.valueOf(commonStatus);
            TaskStatus taskStatusEnum = null;

            if (taskStatus != null && !taskStatus.isEmpty()) {
                taskStatusEnum = TaskStatus.valueOf(taskStatus);
            }
            //if you want to get INACTIVE task this using

            if (commonStatus.equals("INACTIVE")) {
                taskPage = taskRepository.findByCommonStatus(commonStatusEnum, pageable);
            } else {
                taskPage = taskRepository.findByCommonStatusAndTaskStatus(commonStatusEnum, taskStatusEnum, pageable);
            }
            // Convert Employee entities to DTOs
            taskDtoList = taskPage.getContent().stream()
                    .map(this::taskIntoTaskDto) // assuming toTaskDto maps Task -> TaskDto
                    .collect(Collectors.toList());


            // Prepare pagination details
            Map<String, Object> paginationDetails = new HashMap<>();
            paginationDetails.put("currentPage", taskPage.getNumber());
            paginationDetails.put("totalItems", taskPage.getTotalElements());
            paginationDetails.put("totalPages", taskPage.getTotalPages());

            // Set response payload properly
            commonResponse.setStatus(true);
            commonResponse.setCommonMessage("Employees fetched successfully.");
            commonResponse.setPayload(Collections.singletonList(taskDtoList)); // Employee list
            commonResponse.setPages(Collections.singletonList(paginationDetails));// Pagination details

        } catch (IllegalArgumentException e) {
            commonResponse.setStatus(false);
            commonResponse.setCommonMessage("Invalid task status or common status.");
        } catch (Exception e) {
            commonResponse.setStatus(false);
            commonResponse.setCommonMessage("An error occurred while fetching tasks.");
        }

        return commonResponse;
    }

    @Override
    public CommonResponse updateStatus(String taskId, String status) {
        CommonResponse commonResponse = new CommonResponse();
   try {
       Task task = taskRepository.getByTaskId(Long.valueOf(taskId));
       switch (status) {
           case "ACTIVE":
               task.setCommonStatus(CommonStatus.ACTIVE);
               taskRepository.save(task);
               commonResponse.setStatus(true);
               commonResponse.setCommonMessage("Task recovered for bin");
               break;
           case "INACTIVE":
               task.setCommonStatus(CommonStatus.INACTIVE);
               taskRepository.save(task);
               commonResponse.setStatus(true);
               commonResponse.setCommonMessage("Task deleted");
                break;
           case "COMPLETED":
               task.setTaskStatus(TaskStatus.COMPLETED);
               taskRepository.save(task);
               commonResponse.setStatus(true);
               commonResponse.setCommonMessage("Task completed");
                break;
           default:
            commonResponse.setStatus(false);
            commonResponse.setCommonMessage("Invalid task status or common status.");
       }

   } catch (Exception e) {
       commonResponse.setStatus(false);
       LOGGER.error("/**************** Exception in TaskService -> updateStatus()" + e);
   }
       return commonResponse;
    }

    private TaskDto taskIntoTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(String.valueOf(task.getTaskId()));
        taskDto.setTaskTitle(task.getTaskTitle());
        taskDto.setTaskDiscription(task.getTaskDiscription());
        taskDto.setCommonStatus(task.getCommonStatus());
        taskDto.setTaskStatus(task.getTaskStatus());
        return taskDto;
    }


    private List<String> TaskValidation(TaskDto taskDto) {
        List<String> validationList = new ArrayList<>();
        if (CommonValidation.stringNullValidation(taskDto.getTaskTitle()))
            validationList.add("Task title field is empty");
        if (CommonValidation.stringNullValidation(taskDto.getTaskDiscription()))
            validationList.add("Task discription field is empty");
        return validationList;
    }
}
