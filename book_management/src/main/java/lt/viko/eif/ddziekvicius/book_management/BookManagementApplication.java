package lt.viko.eif.ddziekvicius.book_management;

import lt.viko.eif.ddziekvicius.book_management.Library.Book_repo_interface;
import lt.viko.eif.ddziekvicius.book_management.models.Book;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BookManagementApplication {

	private static final Logger log = LoggerFactory.getLogger(BookManagementApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BookManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(Book_repo_interface repository) {
		return (args) -> {
			repository.save(new Book(

					"Tesla",
					"Edison",
					"Science",
					"English",
					"1997-03-21",
					"0-2867-9311-3",
					"71ce12df-aef8-4997-bb66-bc315cef1b62"));
			repository.save(new Book(

					"Arron",
					"Anny",
					"Fantasy",
					"English",
					"1997-03-21",
					"0-4680-6220-3",
					"f769a7c7-2939-4667-a2d7-621f5cc072e8"));
			repository.save(new Book(

					"Avatar",
					"Spielberg",
					"Fantasy",
					"English",
					"1997-03-21",
					"0-4626-8595-0",
					"11c79af1-afe1-4056-aa13-9f1d6f75d0b3"));
			repository.save(new Book(
					"Arron",
					"J.K.Rowling",
					"Fantasy",
					"English",
					"1997-03-21",
					"0-8770-5789-3",
					"e6435ab9-a321-4154-82a6-3ec1ed2308f3"));

		};


}}
