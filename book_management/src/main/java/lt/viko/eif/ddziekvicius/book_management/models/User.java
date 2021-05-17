package lt.viko.eif.ddziekvicius.book_management.models;

import java.util.List;

public class User {
    private String Name;
    private String Surname;
    private int Password;
    private int NumberOfBooks;
    private List<Book> takenBooks;

    public User(String name, String surname, int password) {
        Name = name;
        Surname = surname;
        Password = password;
    }
    public User(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public int getNumberOfBooks() {
        return NumberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        NumberOfBooks = numberOfBooks;
    }

    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(List<Book> book) {
        this.takenBooks = book;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Password='" + Password + '\'' +
                ", NumberOfBooks=" + NumberOfBooks +
                ", takenBooks=" + takenBooks +
                '}';
    }
}
