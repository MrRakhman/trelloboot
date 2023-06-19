package kz.bitlab.techorda.trelloboot.controller;

import kz.bitlab.techorda.trelloboot.model.Folders;
import kz.bitlab.techorda.trelloboot.model.TaskCategories;
import kz.bitlab.techorda.trelloboot.model.Tasks;
import kz.bitlab.techorda.trelloboot.repository.FolderRepository;
import kz.bitlab.techorda.trelloboot.repository.TaskCategoriesRepository;
import kz.bitlab.techorda.trelloboot.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final FolderRepository folderRepository;
    private final TasksRepository tasksRepository;
    private final TaskCategoriesRepository taskCategoriesRepository;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<Folders> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        return "index";
    }

    @GetMapping(value = "/folder-details/{folderId}")
    public String detailsFolder(@PathVariable(name="folderId") Long id, Model model){
        Folders folder = folderRepository.findById(id).orElse(null);
        model.addAttribute("folder", folder);

        List<Tasks> tasks = tasksRepository.findAll();
        model.addAttribute("tasks", tasks);

        List<TaskCategories> categories = taskCategoriesRepository.findAll();
        model.addAttribute("categories", categories);
        return "details";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folders folder){
        folderRepository.save(folder);
        return "redirect:/";
    }
}