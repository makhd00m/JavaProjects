package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.tasks.dtos.CreateTaskDTO;
import com.scaler.taskmanager.tasks.dtos.TaskResponseDTO;
import com.scaler.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskResponseDTO>> getAllTasks(@RequestBody TasksService.TaskFilter filter) {
        TasksService.TaskFilter taskFilter = TasksService.TaskFilter.fromQueryParams(filter.beforeDate, filter.afterDate, filter.completed);
        var tasks = tasksService.getAllTasks(filter);

        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();

        for(Task task : tasks) {
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO(task.getId()
                                                                ,task.getName()
                                                                ,task.getDueDate()
                                                                ,task.getCompleted());
            taskResponseDTOS.add(taskResponseDTO);
        }
        return ResponseEntity.ok(taskResponseDTOS);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(task.getId()
                , task.getName()
                , task.getDueDate()
                , task.getCompleted());
        return ResponseEntity.ok(taskResponseDTO);
    }

    @PostMapping("")
    ResponseEntity<TaskResponseDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        var task = tasksService.createTask(createTaskDTO);

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(task.getId()
                ,task.getName()
                ,task.getDueDate()
                ,task.getCompleted());
        return ResponseEntity.ok(taskResponseDTO);
    }

    @PatchMapping("/{id}")
    ResponseEntity<TaskResponseDTO> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        var task = tasksService.updateTask(id, updateTaskDTO);

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(task.getId()
                                                            ,task.getName()
                                                            ,task.getDueDate()
                                                            ,task.getCompleted());
        return ResponseEntity.ok(taskResponseDTO);
    }

    @DeleteMapping({"/{id}"})
    ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id) {
        tasksService.deleteTask(id);
        Void voidExp = null;
        return ResponseEntity.ok(voidExp);
    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(
            {
                    HttpMessageNotReadableException.class,
                    IllegalArgumentException.class,
                    TasksService.TaskNotFoundException.class
            }
    )
    ResponseEntity<String> multiExceptionHandler(Exception e) {
        if(e instanceof HttpMessageNotReadableException) {
            return ResponseEntity.badRequest().body("Invalid request body");
        } else if (e instanceof IllegalArgumentException) {
            return ResponseEntity.internalServerError().body("Illegal Argument");
        } else if (e instanceof TasksService.TaskNotFoundException) {
            return ResponseEntity.internalServerError().body("TaskNotFound" + e.getMessage());
        } else {
            return ResponseEntity.internalServerError().body("idk - something wrong happened");
        }
    }
}
