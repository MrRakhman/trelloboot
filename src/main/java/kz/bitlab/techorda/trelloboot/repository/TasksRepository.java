package kz.bitlab.techorda.trelloboot.repository;

import kz.bitlab.techorda.trelloboot.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findByFolderId(Long folderId);
}
