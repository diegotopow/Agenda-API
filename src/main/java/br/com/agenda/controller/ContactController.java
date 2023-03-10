package br.com.agenda.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.com.agenda.dto.ContactDTO;
import br.com.agenda.service.ContactService;

@Validated
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public @ResponseBody List<ContactDTO> list() {
        return contactService.list();
    }

    @GetMapping("/{id}")
    public ContactDTO findById(@PathVariable @NotNull @Positive Long id){
        return contactService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContactDTO create(@RequestBody @Valid @NotNull ContactDTO contact){
        return contactService.create(contact);
    }

    @PutMapping("/{id}")
    public ContactDTO update(@PathVariable @NotNull @Positive Long id,
                             @RequestBody @Valid @NotNull ContactDTO contact){
        return contactService.update(id, contact);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
        contactService.delete(id);
    }
}
