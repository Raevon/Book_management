package lt.viko.eif.ddziekvicius.book_management.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String Category;
    private String Language;
    private String Publication_date;
    private String ISBN;
    private String GUID;


    public String getPublication_date() {
        return Publication_date;
    }

    public void setPublication_date(String publication_date) {
        Publication_date = publication_date;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String guid) {
        this.GUID = guid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getAurhor() {
        return author;
    }

    public void setAurhor(String author) {
        author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public Book(String name, String Author, String category, String language, String publication_date, String ISBN, String guid) {
        this.name = name;
        this.author = Author;
        this.Category = category;
        this.Language = language;
        this.Publication_date = publication_date;
        this.ISBN = ISBN;
        this.GUID = guid;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + name + '\'' +
                ", Author='" + author + '\'' +
                ", Category='" + Category + '\'' +
                ", Language='" + Language + '\'' +
                ", Publication_date='" + Publication_date + '\'' +
                ", ISBN=" + ISBN +
                ", GUID=" + GUID +
                '}';
    }
}
