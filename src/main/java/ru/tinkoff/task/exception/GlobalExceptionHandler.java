package ru.tinkoff.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.tinkoff.task.dto.ErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleIllegalArgumentException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        return new ErrorDto(400, message);
    }

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleApiException(Exception ex) {
        return new ErrorDto(400, "Something went wrong");
    }

}
