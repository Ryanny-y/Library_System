package model;

import java.awt.Image;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;
import config.ConnDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Book_Model {
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
    
    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_d) {
        this.book_id= book_id;
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
    

    private int book_id, year_published;
    private String title, author, cover_img, overview;
    private Book_Status status;
    private LocalDateTime created_at;
    public static ArrayList<Book_Model> bookLists = new ArrayList<>();
    public static ArrayList<Book_Model> origList = new ArrayList<>();
    public static ArrayList<Book_Model> searchList = new ArrayList<>();
    
    public void filterList(String search) {
        searchList.clear(); // Clear previous results

        String query = "SELECT * FROM books WHERE title LIKE ?";
        ConnDB con = ConnDB.getInstance();
        Connection c = con.getConnection();
        
        if(search.isEmpty() || search.equalsIgnoreCase("Search")) {
            bookLists.clear();
            bookLists.addAll(origList);
            return;
        }
        
        System.out.println("executed!");

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, "%" + search + "%"); // Allow partial matches

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String overview = rs.getString("overview");
                int year_published = rs.getInt("year_published");
                String cover_img = rs.getString("cover_img");
                String statusDB = rs.getString("status");
                Book_Status status = Book_Status.valueOf(statusDB);

                Timestamp c_time = rs.getTimestamp("created_at");
                LocalDateTime created_at = (c_time != null) ? c_time.toLocalDateTime() : null;

                Book_Model book = new Book_Model(book_id, title, author, overview, year_published, cover_img, status, created_at);
                searchList.add(book);
            }

            bookLists.clear();
            bookLists.addAll(searchList);

        } catch (SQLException ex) {
            Logger.getLogger(Book_Model.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
    }

    public static void resetBookList() {
        bookLists.clear();
        origList.clear();
    }
    
    public void getBooks(String query, Object... params) {
        ConnDB con = ConnDB.getInstance();
        Connection c = con.getConnection();
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            for(int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String overview = rs.getString("overview");
                int year_published = rs.getInt("year_published");
                String cover_img = rs.getString("cover_img");
                String statusDB = rs.getString("status");
                Book_Status status = Book_Status.valueOf(statusDB);

                Timestamp c_time = rs.getTimestamp("created_at");
                LocalDateTime created_at = (c_time != null) ? c_time.toLocalDateTime() : null;

                Book_Model book = new Book_Model(book_id, title, author, overview, year_published, cover_img, status, created_at);

                origList.add(book);
            }
            
            bookLists.addAll(origList);
            
        } catch (SQLException ex) {
            Logger.getLogger(Book_Model.class.getName()).log(Level.SEVERE, "Database error", ex);
        }
        
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
    
    
    public Book_Model(int book_id, String title, String author, String overview, int year_published, String cover_img,  Book_Status status, LocalDateTime created_at) {
        this.book_id = book_id; 
        this.year_published= year_published;
        this.title = title;
        this.author = author;
        this.cover_img = cover_img;
        this.overview = overview;
        this.status = status;
        this.created_at = (created_at != null) ? created_at : null;
    }
    
    public Book_Model() {
        
    }
}
