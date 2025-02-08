package model;

import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Book_Model {
    
    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public LocalDate getBorrowed_date() {
        return borrowed_date;
    }
    
    public void setBorrowed_date(LocalDate borrowed_date) {
        this.borrowed_date = borrowed_date;
    }

    private int id, year_published;
    private String title, author, cover_img;
    private boolean isAvailable;
    private LocalDate borrowed_date;
    
    public Book_Model(int id, int year_published, String title, String author, String cover_img, boolean isAvailable, LocalDate borrowed_date) {
        setId(id);
        setYear_published(year_published);
        setTitle(title);
        setAuthor(author);
        setCover_img(cover_img);
        setIsAvailable(isAvailable);
        setBorrowed_date(borrowed_date);
    }
}
