package app.project.shared.exceptions;

public class AddingExistingIdException extends RuntimeException {

    public AddingExistingIdException(Class<?> entityClass, Class<?> targetClass, Long id) {
        super("Be carefull " + entityClass.getSimpleName() + " have already " + targetClass.getSimpleName() + " with ID: " + id + " , can't be added");
    }
}
