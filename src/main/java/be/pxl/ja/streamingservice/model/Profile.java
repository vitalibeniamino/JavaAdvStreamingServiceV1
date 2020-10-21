package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

public class Profile implements Comparable<Profile> {
    private String name;
    private LocalDate dateOfBirth;
    private String avatar;
    private List<Content> recentlyWatched = new ArrayList<>();
    private List<Content> currentlyWatching = new ArrayList<>();
    private List<Content> myList = new ArrayList<>();

    public Profile(String name) {
        this.name = name;
        this.avatar = "profile1";
    }

    public Profile(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (LocalDate.now().isBefore(dateOfBirth)) {
            throw new InvalidDateException(dateOfBirth, "birth of date", "The date of birth is in the future.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return LocalDate.now().minusYears(dateOfBirth.getYear()).minusDays(dateOfBirth.getDayOfYear()).getYear();
    }

    public void startWatching(Content content) {
        if (!currentlyWatching.contains(content)) {
            currentlyWatching.add(0, content);
        }
    }

    public void finishWatching(Content content) {
        currentlyWatching.remove(content);
        recentlyWatched.add(0, content);
    }

    public void addToMyList(Content content) {
        if (!myList.contains(content)) {
            myList.add(content);
        }
    }
    
    public void removeFromMyList(Content content) {
        if (!myList.contains(content)) {
            myList.add(content);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

	@Override
	public int compareTo(Profile o) {
		return getName().compareTo(o.getName());
	}
}
