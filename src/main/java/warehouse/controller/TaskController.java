package warehouse.controller;


import warehouse.model.Task;
import warehouse.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {


    public TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasksindex";
    }

    @PostMapping("tasks/add")
    public String addTask(@ModelAttribute Task incomeTask) {
        Task task = new Task();
        task.setOwner(incomeTask.getOwner());
        task.setLabel(incomeTask.getLabel());
        task.setDate(incomeTask.getDate());
        String operationResult = taskService.createTask(task).getLabel();
        return "redirect:/tasks@message:task added" + operationResult;
    }

    @PostMapping("tasks/update")
    public String updateTask(@ModelAttribute Task incomeTask) {
        Task task = taskService.getTaskById(incomeTask.getId());
        if (task == null) {
            return " no object to update!";
        }
        task.setDate(incomeTask.getDate());
        task.setLabel(incomeTask.getLabel());
        task.setOwner(incomeTask.getOwner());
        taskService.createTask(task);
        return "redirect:/tasks@message:task updated";
    }

    @GetMapping("tasks/delete")
    public String deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}

