package be.pxl.ja.streamingservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ProfileTest {
    @Test
    public void ifBornOn06092000ItShouldReturn20() {
        Profile profile = new Profile("test20");
        profile.setDateOfBirth(LocalDate.of(2000, 9, 6));

        assertEquals(20, profile.getAge());
    }

    @Test
    public void ifBornOn06112000ItShouldReturn20() {
        Profile profile = new Profile("test19");
        profile.setDateOfBirth(LocalDate.of(2000, 11, 6));

        assertEquals(19, profile.getAge());
    }
}
