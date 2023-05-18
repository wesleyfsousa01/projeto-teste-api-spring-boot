package projetoteste.apispringboot.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ObjectNotFoundException(Object id) {
        super("Objeto não encontrado. Id " + id);
    }
}
