package med.voll.api.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorsHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorHandle404() {
       return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorHandle400(MethodArgumentNotValidException e) {
        List<ErrorValidationDTO> errors = e.getFieldErrors().stream()
                .map(ErrorValidationDTO::new)
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorValidationDTO(String field, String error) {
        public ErrorValidationDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
