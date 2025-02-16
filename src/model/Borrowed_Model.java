package model;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class Borrowed_Model extends Book_Model{

    public int getBook_id() {
        return super.getBook_id();
    }

    public void setBook_id(int book_id) {
        super.setBook_id(book_id);
    }


    public Borrowed_Model(int book_id, String student_id, LocalDateTime borrowed_at, LocalDateTime returned_at, LocalDate due_date) {
        this.book_id = book_id;
        this.student_id = student_id;
        this.borrowed_at = borrowed_at;
        this.returned_at = returned_at;
        this.due_date = due_date;
    }
    
    private int book_id;
    private String student_id;
    private LocalDateTime borrowed_at, returned_at;
    private LocalDate due_date;
    private double penalty = 200;
    
    
    
}
