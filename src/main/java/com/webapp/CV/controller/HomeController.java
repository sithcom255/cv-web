package com.webapp.CV.controller;

import com.webapp.CV.domain.Task;
import com.webapp.CV.repository.TaskRepository;
import com.webapp.CV.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String header(Model model) {
        model.addAttribute("name", "udelat web");
        Task task1 = new Task();
        task1.setName("curak");
        Task task2 = new Task();
        task2.setName("konsky kokot");
        List<Task> ukol =new ArrayList<>();

        ukol.add(task1);
        ukol.add(task2);

        model.addAttribute("taskx", taskService.getAll());
        Task taskk=new Task();
        model.addAttribute("task2",taskk);
        return "tasks";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public String header(@ModelAttribute("task2") Task task, HttpServletRequest request){
        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
