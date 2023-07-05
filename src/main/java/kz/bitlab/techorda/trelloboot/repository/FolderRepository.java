package kz.bitlab.techorda.trelloboot.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techorda.trelloboot.model.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folders, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Tasks t WHERE t.folder.id = :folderId")
    void deleteTasksByFolderId(@Param("folderId") Long folderId);
}
