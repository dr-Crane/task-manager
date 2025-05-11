package com.example.task.manager.controller.view;

import com.example.task.manager.dal.Bug;
import com.example.task.manager.dal.Priority;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bug")
@RequiredArgsConstructor
public class BugViewController {

    private final TaskService taskService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("taskDto", new CreateUpdateTaskDto());
        model.addAttribute("priorities", Priority.values());
        return "createBugForm";
    }

    @PostMapping("/save")
    public String saveData(@ModelAttribute CreateUpdateTaskDto dto) {
        taskService.create(dto);
        return "redirect:/bug/list";
    }

    @GetMapping("/list")
    public String showBugs(Model model) {
        List<Task> bugs = taskService.read();//TODO: сделать так, чтобы были получены только "баги"
        model.addAttribute("bugs", bugs);
        return "bugsList";
    }

}
