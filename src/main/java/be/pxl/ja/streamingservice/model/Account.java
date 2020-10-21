package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

import be.pxl.ja.streamingservice.exception.*;
import be.pxl.ja.streamingservice.util.PasswordUtil;

public class Account {
    private static final int MINIMUM_PASSWORD_STRENGTH = 5;
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();

    public Account(String email, String password) {
        if (email == null || "".equals(email) || password == null || "".equals(password)) {
            throw new IllegalArgumentException("Email or Password are not filled in.");
        }
        this.email = email;
        setPassword(password);

        profiles.add(new Profile("Profile1"));
        streamingPlan = StreamingPlan.BASIC;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile) {
        if (getNumberOfProfiles() >= streamingPlan.getNumberOfScreens()) {
            throw new TooManyProfilesException();
        }
    }
    
    public String getEmail() {
        return email;
    }

    public boolean verifyPassword(String password) {

    }
    
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }
    
    public void setPassword(String password) {
        if (PasswordUtil.calculateStrength(password) < MINIMUM_PASSWORD_STRENGTH)
            throw new IllegalArgumentException("Password is not strong enough.");
        this.password = password;
    }

    public int getNumberOfProfiles() {
        return profiles.size();
    }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
