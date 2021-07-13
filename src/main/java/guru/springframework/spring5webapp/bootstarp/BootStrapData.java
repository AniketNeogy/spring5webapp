package guru.springframework.spring5webapp.bootstarp;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Publisher chayaPublisher = new Publisher();
        chayaPublisher.setName("Chaya Publishing");
        chayaPublisher.setCity("Kolkata");
        chayaPublisher.setState("West Bengal");

        publishRepository.save(chayaPublisher);
        System.out.println("Publisher Count = "+publishRepository.count());

        Author chetan = new Author("Chetan", "Bhagat");
        Book threeMistakes =  new Book("3 Mistakes of my life", "12345678");
        chetan.getBooks().add(threeMistakes);
        threeMistakes.getAuthors().add(chetan);

        authorRepository.save(chetan);
        bookRepository.save(threeMistakes);

        Author robin = new Author("Robin", "Singh");
        Book monkSoldFerrari =  new Book("The monk who sold his ferrari", "23456123");
        robin.getBooks().add(monkSoldFerrari);
        monkSoldFerrari.getAuthors().add(robin);

        authorRepository.save(robin);
        bookRepository.save(monkSoldFerrari);

        System.out.println("Inside Spring BootStrap.......");
        System.out.println("Number Of Books = "+bookRepository.count());
    }
}
