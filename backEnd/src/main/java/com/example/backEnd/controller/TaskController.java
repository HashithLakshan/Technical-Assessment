package com.example.backEnd.controller;

import com.example.backEnd.dto.TaskDto;
import com.example.backEnd.service.TaskService;
import com.example.backEnd.utill.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/Save")
    CommonResponse TaskSave ( @RequestBody TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @GetMapping("/filtered")
    public CommonResponse getFilteredTasks(
            @RequestParam String commonStatus,
            @RequestParam(required = false) String taskStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return taskService.getFilteredTasks(commonStatus, taskStatus, page, size);
    }

    @PutMapping("/updateStatus")
    public CommonResponse TaskUpdateStatus(  @RequestParam String taskId,
                                             @RequestParam String status) {
        return taskService.updateStatus(taskId,status);

    }
}
