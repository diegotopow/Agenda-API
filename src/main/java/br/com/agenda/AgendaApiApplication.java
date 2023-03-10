package br.com.agenda;

import br.com.agenda.model.Contact;
import br.com.agenda.repository.ContactRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ContactRepository contactRepository) {
        return args -> {
            contactRepository.deleteAll();

            Contact c = new Contact();
            c.setName("Diego");
            c.setSurname("Topow");
            c.setNumber("+55 xx 9xxxx-xxxx");
            c.setBirthdate("12/07/1985");
            c.setEmail("xx.xxxxxx@gmail.com");
            c.setAdress("Rua Xxxx Xxxxxx, xxxx");
            c.setNote("Testing");

            contactRepository.save(c);
        };
    }
}