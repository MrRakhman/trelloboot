package kz.bitlab.techorda.trelloboot.repository;

import kz.bitlab.techorda.trelloboot.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
}
