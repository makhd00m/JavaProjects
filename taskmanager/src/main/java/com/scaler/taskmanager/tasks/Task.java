package com.scaler.taskmanager.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Task {
    Integer id;
    String name;
    Date dueDate;
    Boolean completed;
}