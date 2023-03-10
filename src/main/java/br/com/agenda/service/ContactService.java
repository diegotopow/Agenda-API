package br.com.agenda.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.agenda.dto.ContactDTO;
import br.com.agenda.exception.RecordNotFoundException;
import br.com.agenda.dto.mapper.ContactMapper;
import br.com.agenda.repository.ContactRepository;

@Validated
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public List<ContactDTO> list() {
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO findById(@PathVariable @NotNull @Positive Long id) {
        return contactRepository.findById(id).map(contactMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ContactDTO create(@Valid @NotNull ContactDTO contact) {
        return contactMapper.toDTO(contactRepository.save(contactMapper.toEntity(contact)));
    }

    public ContactDTO update(@NotNull @Positive Long id, @Valid @NotNull ContactDTO contact) {
        return contactRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(contact.name());
                    recordFound.setSurname(contact.surname());
                    recordFound.setNumber(contact.number());
                    recordFound.setBirthdate(contact.birthdate());
                    recordFound.setEmail(contact.email());
                    recordFound.setAdress(contact.adress());
                    recordFound.setNote(contact.note());
                    return contactMapper.toDTO(contactRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        contactRepository.delete(contactRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
