package warehouse.controller;


import warehouse.model.Task;
import warehouse.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskRestController {


    public TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("api/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("api/tasks/{id}")
    public Task getTasks(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("api/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("api/tasks/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("api/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        return taskService.deleteTask(id);
    }
}
