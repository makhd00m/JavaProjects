package com.scaler.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksService {
    private List<Task> tasks = new ArrayList<>();
    private Integer id = 0;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Integer id) {
        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public Task craeteTask(String name, Date dueDate) {
        Task task = new Task(id++, name, dueDate, false);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Integer id, Date dueDate, Boolean completed) {
        Task task = getTaskById(id);
        if(task == null) {
            return null;
        }
        if(dueDate != null) {
            task.setDueDate(dueDate);
        }
        if(completed != null) {
            task.setCompleted(completed);
        }
        return task;
    }

    public Boolean deleteTask(Integer id) {
        Task task = getTaskById(id);
        if(task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }
}
