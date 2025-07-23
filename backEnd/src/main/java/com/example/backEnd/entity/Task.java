package com.example.backEnd.entity;

import com.example.backEnd.constant.CommonStatus;
import com.example.backEnd.constant.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_Id")
    private Long taskId;

    @Column(name = "task_Title",nullable = false, length = 25)
    private String taskTitle;

    @Column(name = "task_Discription",nullable = false, length = 100)
    private String taskDiscription;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommonStatus commonStatus;

}
