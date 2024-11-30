package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {




}
