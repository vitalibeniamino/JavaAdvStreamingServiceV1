package be.pxl.ja.streamingservice.model;

public enum CreditCardType {
    VISA(4), MASTERCARD(5);

    private int firstnumber;

    CreditCardType(int firstnumber) {
        this.firstnumber = firstnumber;
    }

    public int getFirstNumber() {
        return firstnumber;
    }
}
