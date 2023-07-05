package kz.bitlab.techorda.trelloboot.service;

import kz.bitlab.techorda.trelloboot.model.TaskCategories;
import kz.bitlab.techorda.trelloboot.repository.TaskCategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final TaskCategoriesRepository taskCategoriesRepository;
    public List<TaskCategories> getCategoryList(){
        return taskCategoriesRepository.findAll();
    }

    public TaskCategories getCategory(Long id){
        return taskCategoriesRepository.findById(id).orElse(null);
    }
}
