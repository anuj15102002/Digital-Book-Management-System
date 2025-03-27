package com.book.management.system.dto;

import com.book.management.system.dto.interfaces.BookDTOInterface;
import com.book.management.system.enums.Availability;

import static com.book.management.system.enums.Availability.AVAILABLE;

public class BookDTO implements BookDTOInterface {

    private String id;
    private String title;
    private String author;
    private String genre;
    private Availability availablityStatus;

    public BookDTO()
    {
        this.id=null;
        this.title=null;
        this.author=null;
        this.genre=null;
        this.availablityStatus=AVAILABLE;
    }

    public BookDTO(String id, String title, String author, String genre, Availability availability
    ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availablityStatus = availability;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Availability isAvailable() {
        return availablityStatus;
    }

    public void setAvailable(Availability available) {
        availablityStatus = available;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
