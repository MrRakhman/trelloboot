package kz.bitlab.techorda.trelloboot.controller;

import kz.bitlab.techorda.trelloboot.model.Folders;
import kz.bitlab.techorda.trelloboot.model.TaskCategories;
import kz.bitlab.techorda.trelloboot.model.Tasks;
import kz.bitlab.techorda.trelloboot.service.CategoryService;
import kz.bitlab.techorda.trelloboot.service.FolderService;
import kz.bitlab.techorda.trelloboot.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final FolderService folderService;
    private final TaskService taskService;
    private final CategoryService categoryService;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        model.addAttribute("folders", folderService.getFoldersList());
        return "index";
    }

    @GetMapping(value = "/folder-details/{folderId}")
    public String detailsFolder(@PathVariable(name = "folderId") Long folderId,
                                Model model){
        Folders folder = folderService.getFolder(folderId);
        model.addAttribute("folder", folder);

        List<Tasks> tasks = taskService.getTasksList(folderId);
        model.addAttribute("tasks", tasks);

        List<TaskCategories> categories = categoryService.getCategoryList();
        model.addAttribute("categories", categories);

        return "details";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folders folder){
        folderService.saveFolder(folder);
        return "redirect:/";
    }

    @PostMapping(value = "/remove-folder")
    public String deleteFolder(@RequestParam(name = "folderId") Long folderId){
        folderService.removeFolder(folderId);
        return "redirect:/";
    }

    @PostMapping(value = "/add-task/{folderId}")
    public String addTask(@PathVariable(name = "folderId") Long folderId, Tasks task) {
        taskService.addTask(folderId, task);
        return "redirect:/folder-details/" + folderId;
    }

    @PostMapping(value = "/add-category/{folderId}")
    public String addCategory(@PathVariable(name = "folderId") Long folderId,
                              @RequestParam(name = "categoryId") Long categoryId){
        folderService.addCategory(folderId, categoryId);
        return "redirect:/folder-details/" + folderId;
    }

    @PostMapping(value = "/remove-category/{folderId}")
    public String removeCategory(@PathVariable(name = "folderId") Long folderId,
                                 @RequestParam(name = "categoryId") Long categoryId){
        folderService.removeCategory(folderId, categoryId);
        return "redirect:/folder-details/" +folderId;
    }


    @GetMapping(value = "/change-task/{folderId}/{taskId}")
    public String changeTaskPage(@PathVariable(name = "folderId") Long folderId,
                                 @PathVariable(name = "taskId") Long taskId,
                                 Model model){
        Folders folder = folderService.getFolder(folderId);
        model.addAttribute("folder", folder);

        Tasks task = taskService.getTask(taskId);
        model.addAttribute("task", task);

        return "task_details";
    }
    @PostMapping(value = "/change-task/{folderId}")
    public String changeTask(@PathVariable(name = "folderId") Long folderId,
                             @RequestParam(name = "taskId") Long taskId,
                             @RequestParam(name = "status") int status){
        taskService.changeTaskStatus(taskId, status);
        return "redirect:/folder-details/" + folderId;
    }
}