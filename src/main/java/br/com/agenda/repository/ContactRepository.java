package br.com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}