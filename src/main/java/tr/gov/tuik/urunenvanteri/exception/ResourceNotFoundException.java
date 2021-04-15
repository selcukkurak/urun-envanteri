package tr.gov.tuik.urunenvanteri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String entity, String property, Object value) {
        super(String.format("%s = %s olan %s nesnesi bulunamadı", property, value, entity).toString());
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
