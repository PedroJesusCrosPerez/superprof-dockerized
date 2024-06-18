package app.project.shared.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entityClass, Long id) {
        super("No " + entityClass.getSimpleName() + " found with ID: " + id);
    }

    public NotFoundException(Class<?> entityClass, String key) {
        super("No " + entityClass.getSimpleName() + " found: " + key);
    }

    public NotFoundException(Class<?> entityClass, Object key) {
        super("No " + entityClass.getSimpleName() + " found with KEY: " + key);
    }
}
