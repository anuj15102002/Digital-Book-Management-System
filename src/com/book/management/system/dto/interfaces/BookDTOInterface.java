package com.book.management.system.dto.interfaces;

import com.book.management.system.enums.Availability;

import java.io.Serializable;

public interface BookDTOInterface extends Serializable{
   public void setId(String id);
   public void setAuthor(String author);
   public void setTitle(String title);
   public void setGenre(String genre);
   public void setAvailabilityStatus(Availability availabilityStatus);

   public String getId();
   public String getAuthor();
   public String getTitle();
   public String getGenre();
   public Availability getAvailabilityStatus();




}
