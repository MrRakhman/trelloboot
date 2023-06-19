package kz.bitlab.techorda.trelloboot.repository;

import kz.bitlab.techorda.trelloboot.model.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folders, Long> {
}
