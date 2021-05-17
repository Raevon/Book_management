package lt.viko.eif.ddziekvicius.book_management.Controllers;

import lt.viko.eif.ddziekvicius.book_management.Library.Book_repo_interface;
import lt.viko.eif.ddziekvicius.book_management.Library.UserRepo;
import lt.viko.eif.ddziekvicius.book_management.models.Book;
import lt.viko.eif.ddziekvicius.book_management.models.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * Rest controller working with books ednpoints
 */
@RestController
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class Controller {

    private final UserRepo repository2= new UserRepo();
    private Book_repo_interface repository;
    private UserRepo userRepo= new UserRepo();
    private List<Book> TAKEN= new ArrayList<>();
    private List<Book> FOUNDED= new ArrayList<>();
    private String BOOK_NAME=" ";
    private String AUTHOR_NAME=" ";
    Controller(Book_repo_interface repository) {
        this.repository = repository;

    }

    /**
     *
     * @param date takes book for certain date if nor more than 60 days
     * @return returns book to users taken books list
     * @throws Exception
     */
    @RequestMapping(path = "/books/findByName/take/{date}", method = RequestMethod.GET)
public User takebook( @PathVariable String date) throws Exception {
    LocalDate localDate = LocalDate.now();
    String firstdate= String.valueOf(localDate);
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    final LocalDate firstDate = LocalDate.parse(firstdate, formatter);
    final LocalDate secondDate = LocalDate.parse(date, formatter);
    final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        userRepo.Login("Adam",12345);
        if(userRepo.GetLoggedInUser().equals(null)||days>60||repository2.GetLoggedInUser().getNumberOfBooks()>2){
            return null;
        }
        else{

            for(Book book : repository.findAll()){
                if(book.getName().equals(BOOK_NAME)&&book.getAurhor().equals(AUTHOR_NAME)){
                    System.out.println(book.toString());
                    TAKEN.add(book);
                    userRepo.GetLoggedInUser().setTakenBooks(TAKEN);
                    userRepo.GetLoggedInUser().setNumberOfBooks(userRepo.GetLoggedInUser().getTakenBooks().size());
                }
            }
        }
           return userRepo.GetLoggedInUser();
    }

    /**
     *
     * @return returns book list
     */
    @GetMapping("/books")
        List<Book> allBoks(){
        return repository.findAll();
}

    /**
     *
     * @param name takes name of the book and searches
     * @param author takes author of the book searches (name+author combination is very unique)
     * @return returns searching book
     */
    @RequestMapping(path="/books/findByName/{name}/{author}", method = RequestMethod.GET)
    public List<Book> getBook(@PathVariable String name,@PathVariable String author) {
FOUNDED.clear();
        for (Book book : repository.findAll()) {
            if(book.getName().equals(name)&& book.getAurhor().equals(author)){
                BOOK_NAME=book.getName();
                AUTHOR_NAME=book.getAurhor();
                FOUNDED.add(book);
                System.out.println(BOOK_NAME+AUTHOR_NAME);
            }

        }
        return FOUNDED;
    }

    /**
     *
     * @param name name of the book
     * @param author author of the book
     * @param category category of the book
     * @param language language of the book
     * @param date date of the book
     * @param ISBN ISBN of the book
     * @param Guid guid of the book
     * @return returns new book to the list
     */
    @RequestMapping(path= "/books/new/{name}/{author}/{category}/{language}/{date}/{ISBN}/{Guid}", method = RequestMethod.GET)
    Book newBook(@PathVariable String name,@PathVariable String author, @PathVariable String category,
                 @PathVariable String language,@PathVariable String date, @PathVariable String ISBN,@PathVariable String Guid){

        return repository.save(new Book(name,author,category,language,date,ISBN,Guid));

    }

    /**
     *
     * @param guid param to find by guid
     * @return returns book searched by guid
     */
    @RequestMapping(path="/books/findbyGuid/{guid}",method = RequestMethod.GET)
           List<Book> findbyGuid(@PathVariable String guid){
        FOUNDED.clear();
        repository.findByGUID(guid).forEach(book -> {
           FOUNDED.add(book);

        });
                    return FOUNDED;
    }

    /**
     *
     * @param name takes name to delete
     * @param author rakes authir to delete
     * @return deletes book from the list
     */
    @RequestMapping(path="/books/delete/{name}/{author}",method = RequestMethod.GET)
    List<Book> deleteBook(@PathVariable String name,@PathVariable String author){
        for (Book book : repository.findAll()) {
            if(book.getName().equals(name)&& book.getAurhor().equals(author)){
              repository.delete(book);

            }


        }
        return repository.findAll();

   }
}



