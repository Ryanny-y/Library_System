package model;

import java.awt.Image;
import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Book_Model {

    /**
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }
    
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
    private String title, author, cover_img, overview;
    private boolean isAvailable; // status
    private Book_Status status;
    private LocalDate borrowed_date, created_at;
    
    public enum Book_Status {
        AVAILABLE, RESERVED
    }
    
    public Icon toIcon(JLabel lbl, Book_Model book) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/Books/" + book.getCover_img() + ".jpg"));
        Image image = imageIcon.getImage();
        
        // Get JLabel dimensions
        int labelWidth = lbl.getPreferredSize().width;
        int labelHeight = lbl.getPreferredSize().height;

        // Get original image dimensions
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // Calculate new width and height while keeping aspect ratio
        double widthRatio = (double) labelWidth / imageWidth;
        double heightRatio = (double) labelHeight / imageHeight;
        double ratio = Math.min(widthRatio, heightRatio); // Maintain aspect ratio

        int newWidth = (int) (imageWidth * ratio);
        int newHeight = (int) (imageHeight * ratio);

        // Resize image
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

         return new ImageIcon(resizedImage);
    }
    
    public Book_Model(int id, int year_published, String title, String author, String cover_img, String overview, boolean isAvailable, LocalDate borrowed_date) {
        this.id = id; 
        this.year_published= year_published;
        this.title = title;
        this.author = author;
        this.cover_img = cover_img;
        this.overview = overview;
        this.isAvailable = isAvailable;
        this.borrowed_date = borrowed_date;
    }
}
