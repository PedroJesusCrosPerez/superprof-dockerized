package app.project.shared.exceptions;

public class UnprocessableEntityException extends RuntimeException {

    private final String fieldName;
    private final String errorMessage;

    public UnprocessableEntityException(Class<?> entityClass, String fieldName) {
        super("Invalid data in " + entityClass.getSimpleName() + " for field: " + fieldName);
        this.fieldName = fieldName;
        this.errorMessage = null;
    }

    public UnprocessableEntityException(Class<?> entityClass, String fieldName, String errorMessage) {
        super("Invalid data in " + entityClass.getSimpleName() + " for field: " + fieldName + ". " + errorMessage);
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    public UnprocessableEntityException(String errorMessage) {
        super(errorMessage);
        this.fieldName = null;
        this.errorMessage = errorMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
