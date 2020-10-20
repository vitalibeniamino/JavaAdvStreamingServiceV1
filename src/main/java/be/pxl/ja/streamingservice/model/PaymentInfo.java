package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import be.pxl.ja.streamingservice.exception.*;

public class PaymentInfo {
    private String firstName;
    private String lastName;
    private CreditCardNumber cardNumber;
    private LocalDate expirationDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setCardNumber(CreditCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.plusMonths(1).isAfter(LocalDate.now())) {
            throw new InvalidDateException(expirationDate, "expirationdate", "The expiration will be within 1 month.");
        }
        this.expirationDate = expirationDate;
    }
}
