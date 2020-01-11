package warehouse.service;


import warehouse.model.Task;
import warehouse.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findTaskById(id);
    }

    public Task updateTask(long id, Task task) {
        return taskRepository.findById(id).map(t -> {
            t.setDate(task.getDate());
            t.setLabel(task.getLabel());
            t.setOwner(task.getOwner());
            return taskRepository.save(t);
        }).orElseThrow(() -> new RuntimeException());
    }

    public ResponseEntity<?> deleteTask(long id) {
        return taskRepository.findById(id).map(t -> {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException());
    }


}

