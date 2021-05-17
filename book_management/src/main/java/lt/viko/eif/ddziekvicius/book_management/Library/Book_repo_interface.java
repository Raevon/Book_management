package lt.viko.eif.ddziekvicius.book_management.Library;

import lt.viko.eif.ddziekvicius.book_management.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * JPA repository to operate with books
 */
public interface Book_repo_interface  extends JpaRepository<Book, Integer> {

   List<Book> findByAuthor(String author);
List<Book> findByGUID(String guid);

}
