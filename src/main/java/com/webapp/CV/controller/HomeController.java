package com.webapp.CV.controller;

import com.webapp.CV.domain.Task;
import com.webapp.CV.domain.User;
import com.webapp.CV.repository.TaskRepository;
import com.webapp.CV.service.TaskService;
import com.webapp.CV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping({"/", "index","index.html"})
    public String index() {
        return "index";
    }


    @GetMapping("/tasks")
    public String tasks( Model model) {
        model.addAttribute("todotask",taskService.findByStatus("toDo"));
        model.addAttribute("inProgtask",taskService.findByStatus("inProg"));
        model.addAttribute("doneTask",taskService.findByStatus("done"));
        return "tasks";
    }
    @GetMapping("/MTasks")
    public String MTasks( Model model) {
        model.addAttribute("todotask",taskService.findAllByAssigneeAndStatus(userService.findByName("User 1"),"toDo"));
        model.addAttribute("inProgtask",taskService.findAllByAssigneeAndStatus(userService.findByName("User 1"),"inProg"));
        model.addAttribute("doneTask",taskService.findAllByAssigneeAndStatus(userService.findByName("User 1"),"done"));
        return "MTasks";
    }
    @GetMapping("/getTask")
    public String taskpage(@PathParam("id") long id, Model model) {
        Task task = taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));

        model.addAttribute("task", task);
        return "taskpage";
    }

    @GetMapping("/resetDemo")
    public String reset() {
    userService.deleteAll();
    taskService.deleteAll();

        Task task1 =new Task();
        task1.setStatus("done");
        task1.setName("New Task form");
        task1.setDescription("set up basic functionality");

        Task task2 =new Task();
        task2.setStatus("toDo");
        task2.setName("user login");
        task2.setDescription("set up authentication and learn about sessions");

        Task task3 =new Task();
        task3.setStatus("inProg");
        task3.setName("Editing");
        task3.setDescription("continue on task editing with thymeleaf");

        Task task4 =new Task();
        task4.setStatus("inDo");
        task4.setName("Sleep");
        task4.setDescription("take a break");

        Task task5 =new Task();
        task5.setStatus("inProg");
        task5.setName("Mapping");
        task5.setDescription("Implement many to many mapping for Task and User; good luck");



        User user1=new User();
        user1.setFullName("Thomas");
        User user2=new User();
        user2.setFullName("Lukas");
        User user3=new User();
        user3.setFullName("Ondra");

        task1.setAssignee(user1);
        task3.setAssignee(user1);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

taskService.saveTask(task4);
taskService.saveTask(task5);
        taskService.saveTask(task1);
        taskService.saveTask(task3);
        taskService.saveTask(task2);

        return "resetDemo";
    }

    @GetMapping("/maketask")
    public String newTask(Task task,Model model) {
        model.addAttribute("users", userService.getAll());
        return "newtask";
    }

    @PostMapping("/newtask")
    public String newtask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model){

task.setAssignee(userService.findByName(task.getHelper()));
       taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edittask/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Task task = taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("task", task);
        return "edit";
    }
    @GetMapping("/changeto/{id}")
    public String updateTask(@PathVariable("id") long id, Model model) {
        Task task = taskService.findById(id).get();
        String status = task.getStatus();
        switch (status) {
            case "toDo":
                task.setStatus("inProg");
                taskService.saveTask(task);
                break;
            case "inProg":
                task.setStatus("done");
                taskService.saveTask(task);
                break;
            case "done":
                task.setStatus("hidden");
                taskService.saveTask(task);
                break;
        }
        return "redirect:/tasks";
    }
}
