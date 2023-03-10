package br.com.agenda.exception;

public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Contato não encontrado com o id: " + id);
    }
}