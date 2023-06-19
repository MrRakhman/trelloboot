package kz.bitlab.techorda.trelloboot.repository;

import kz.bitlab.techorda.trelloboot.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
}
