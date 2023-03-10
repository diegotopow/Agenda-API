package br.com.agenda.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.agenda.dto.ContactDTO;
import br.com.agenda.model.Contact;

@Component
public class ContactMapper {
    
    public ContactDTO toDTO(Contact contact) {
        if(contact == null){
            return null;
        }
        return new ContactDTO(
            contact.getId(),
            contact.getName(), 
            contact.getSurname(), 
            contact.getNumber(), 
            contact.getBirthdate(), 
            contact.getEmail(), 
            contact.getAdress(), 
            contact.getNote());
    }

    public Contact toEntity(ContactDTO contactDTO) {

        if (contactDTO == null) {
            return null;
        }

        Contact contact = new Contact();
        if (contactDTO.id() != null) {
            contact.setId(contactDTO.id());
        }
        contact.setName(contactDTO.name());
        contact.setSurname(contactDTO.surname());
        contact.setNumber(contactDTO.number());
        contact.setBirthdate(contactDTO.birthdate());
        contact.setEmail(contactDTO.email());
        contact.setAdress(contactDTO.adress());
        contact.setNote(contactDTO.note());
        contact.setStatus("Ativo");
        return contact;
    }
}