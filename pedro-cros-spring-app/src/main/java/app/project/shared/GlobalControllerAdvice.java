package app.project.shared;

import app.project.shared.exceptions.AddingExistingIdException;
import app.project.shared.exceptions.NotFoundException;
import app.project.shared.exceptions.OrphanForeignKeyEntityException;
import app.project.shared.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomError> handleEntityNotFoundException(NotFoundException ex) {

        return  ResponseEntity
                .status(
                        HttpStatus.NOT_FOUND
                )
                .body(
                        new CustomError(
                                HttpStatus.NOT_FOUND
                                ,ex.getMessage()
                        )
                );
    }


    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        String message;
        if (ex.getFieldName() != null) {
            message = "Invalid data for field '" + ex.getFieldName() + "': " + ex.getErrorMessage();
        } else {
            message = ex.getMessage();
        }

        CustomError customError = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY, message);
        customError.setField(ex.getFieldName());

        return  ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(customError);
    }

    @ExceptionHandler(OrphanForeignKeyEntityException.class)
    public ResponseEntity<CustomError> handleOrphanForeignKeyEntityException(OrphanForeignKeyEntityException ex) {
        String message;
        if (ex.getMessage() != null) {
            message = ex.getMessage();
        } else {
            message = ex.getMessage();
        }

        CustomError customError = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY, message);

        return  ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(customError);
    }
    @ExceptionHandler(AddingExistingIdException.class)
    public ResponseEntity<CustomError> handleOrphanForeignKeyEntityException(AddingExistingIdException ex) {
        String message;
        if (ex.getMessage() != null) {
            message = ex.getMessage();
        } else {
            message = ex.getMessage();
        }

        CustomError customError = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY, message);

        return  ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(customError);
    }

}
