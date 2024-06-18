package app.project.shared.exceptions;

public class OrphanForeignKeyEntityException extends RuntimeException {

    private final String errorMessage;


    public OrphanForeignKeyEntityException(Class<?> entityClass, Long idLeague) {
        super(entityClass.getSimpleName() + " with ID: " + idLeague + " has player or teams associated");
        this.errorMessage = null;
    }

    public OrphanForeignKeyEntityException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
