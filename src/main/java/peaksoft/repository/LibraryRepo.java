package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Library;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {

    @Query("select  c from  Library  c ")
    List<Library> getAllLibrary();
}
