package com.book.management.system.dto.interfaces;

public interface BookDTOInterface extends java.io.Serializable{
    String getId();
    String getTitle();
    String getAuthor();
    String getGenre();
    boolean isAvailable();
}
