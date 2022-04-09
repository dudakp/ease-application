package sk.fei.tp.ease.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BusinessException extends RuntimeException {
    public BusinessException(@Nullable String reason) {
        super(reason);
    }
}
