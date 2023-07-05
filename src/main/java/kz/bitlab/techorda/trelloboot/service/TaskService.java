package kz.bitlab.techorda.trelloboot.service;

import kz.bitlab.techorda.trelloboot.model.Folders;
import kz.bitlab.techorda.trelloboot.model.Tasks;
import kz.bitlab.techorda.trelloboot.repository.FolderRepository;
import kz.bitlab.techorda.trelloboot.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {
    private final TasksRepository tasksRepository;
    private final FolderRepository folderRepository;
    public Tasks getTask(Long id){
        return tasksRepository.findById(id).orElse(null);
    }

    public List<Tasks> getTasksList(Long id){
        return tasksRepository.findByFolderId(id);
    }

    public void changeTaskStatus(Long taskId, int status){
        Tasks task = tasksRepository.findById(taskId).orElse(null);
        task.setStatus(status);
        tasksRepository.save(task);
    }

    public void addTask(Long id, Tasks task){
        Folders folder = folderRepository.findById(id).orElse(null);
        if (folder != null){
            task.setFolder(folder);
            tasksRepository.save(task);
        }
    }
}
