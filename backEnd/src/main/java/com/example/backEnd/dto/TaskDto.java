package com.example.backEnd.dto;

import com.example.backEnd.constant.CommonStatus;
import com.example.backEnd.constant.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {

    private String taskId;

    @Size(min = 3, max = 25, message = "Title must be between 3 and 25 characters")
    private String taskTitle;

    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String taskDiscription;

    private TaskStatus taskStatus;

    private CommonStatus commonStatus;

}
