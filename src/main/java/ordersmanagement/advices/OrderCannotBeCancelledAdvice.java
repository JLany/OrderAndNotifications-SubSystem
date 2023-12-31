package ordersmanagement.advices;

import ordersmanagement.exceptions.OrderCannotBeCancelledException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderCannotBeCancelledAdvice {

    @ResponseBody
    @ExceptionHandler(OrderCannotBeCancelledException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String orderCannotBeCancelledHandler(OrderCannotBeCancelledException ex) {
        return ex.getMessage();
    }
}
