package com.book.management.system.dto.interfaces;

import com.book.management.system.enums.Availability;

public interface BookDTOInterface extends java.io.Serializable{
    String getId();
    String getTitle();
    String getAuthor();
    String getGenre();
    Availability availablityStatus();
}
