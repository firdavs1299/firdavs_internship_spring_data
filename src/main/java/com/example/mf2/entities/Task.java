package com.example.mf2.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Document
public class Task {
    @Id
    private String id;
    private Integer user_created_task_id;
    private Integer executor_id;
    private String task_description;
    private LocalDateTime date_created;
}
