package be.pxl.ja.streamingservice.exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@code InvalidDateException} is a runtime error that occurs when
 * an invalid date is given. It's a subclass of <em>RuntimeException</em>.
 *
 * @author  Vitali Beniamino
 * @since   15.0
 */
public class InvalidDateException extends RuntimeException {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public InvalidDateException(LocalDate incorrectDate, String type, String description) {
        super(FORMATTER.format(incorrectDate) + " is not a valid " + type + ".\n" + description);
    }
}
