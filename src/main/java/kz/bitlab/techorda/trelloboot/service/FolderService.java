package kz.bitlab.techorda.trelloboot.service;

import kz.bitlab.techorda.trelloboot.model.Folders;
import kz.bitlab.techorda.trelloboot.model.TaskCategories;
import kz.bitlab.techorda.trelloboot.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {
    private final FolderRepository folderRepository;
    private final CategoryService categoryService;
    public List<Folders> getFoldersList(){
        return folderRepository.findAll();
    }

    public Folders getFolder(Long id){
        return folderRepository.findById(id).orElse(null);
    }

    public Folders saveFolder(Folders folder){
        return folderRepository.save(folder);
    }

    public void addCategory(Long folderId, Long categoryId){
        Folders folder = folderRepository.findById(folderId).orElse(null);
        TaskCategories category = categoryService.getCategory(categoryId);
        List<TaskCategories> categories = folder.getCategories();
        if (categories != null && categories.size() > 0){
            if (!categories.contains(category)){
                categories.add(category);
            }
        }else{
            List<TaskCategories> newCategories = new ArrayList<>();
            newCategories.add(category);
            folder.setCategories(newCategories);
        }
        folderRepository.save(folder);
    }

    public void removeCategory(Long folderId, Long categoryId){
        Folders folder = folderRepository.findById(folderId).orElse(null);
        TaskCategories category = categoryService.getCategory(categoryId);
        if (folder != null && category != null){
            List<TaskCategories> categories = folder.getCategories();
            if (categories != null && categories.contains(category)){
                categories.remove(category);
                folderRepository.save(folder);
            }
        }
    }

    public void removeFolder(Long id){
        folderRepository.deleteTasksByFolderId(id);
        folderRepository.deleteById(id);
    }
}
