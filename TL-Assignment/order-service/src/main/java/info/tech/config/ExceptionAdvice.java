package info.tech.config;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends  ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      
        FieldError fieldError = ex.getBindingResult().getFieldError();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(status.toString());
        responseDTO.setMessage(fieldError.getDefaultMessage());
           
       
        return ResponseEntity.badRequest().body(responseDTO);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
       
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(ex.getMessage());
           

        return ResponseEntity.badRequest().body(responseDTO);
    }
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<OrderErrorResponse> handleGenericNotFoundException(NotFoundException e) {

		OrderErrorResponse error = new OrderErrorResponse("NOT_FOUND_ERROR", e.getMessage());

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.NOT_FOUND.value()));

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}