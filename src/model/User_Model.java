package model;

import config.ConnDB;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User_Model {

    /**
     * @return the profile_img
     */
    public String getProfile_img() {
        return profile_img;
    }

    /**
     * @param profile_img the profile_img to set
     */
    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getStudent_id() {
        return student_id;
    }
    
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_Role getRole() {
        return role;
    }

    public void setRole(User_Role role) {
        this.role = role;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public LocalDateTime getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(LocalDateTime joined_at) {
        this.joined_at = joined_at;
    }
    
    private String student_id, first_name, last_name, email, password, profile_img;
    private User_Role role = User_Role.USER;
    private double penalty;
    private LocalDateTime joined_at;
    
    public User_Model(String student_id, String first_name, String last_name, String email, String password, String role) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.role = convertRole(role);
    }
    
    public User_Model(String student_id, String first_name, String last_name, String email, String password, String profile_img, String role, double penalty, LocalDateTime joined_at) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.profile_img = profile_img;
        this.role = convertRole(role);
        this.penalty = penalty;
        this.joined_at = joined_at;
    }
    
    private User_Role convertRole(String dbRole) {
        return User_Role.valueOf(dbRole);
    }
    
    public static boolean penaltyCalled = false;
    public static void addPenalty() {
        if(!penaltyCalled) {
            addBookPenalty();
            addUserPenalty();
            penaltyCalled = true;
        }
    }
    
    private static void addUserPenalty() {
        ConnDB con = ConnDB.getInstance();
        Connection c = con.getConnection();
        
        String selectQuery = "SELECT bb.student_id, bb.penalty FROM users INNER JOIN borrowed_books AS bb ON users.student_id = bb.student_id WHERE users.student_id = ? ";
        
        try {
            PreparedStatement ps = c.prepareStatement(selectQuery);
            String student_id = Current_User.getCurrentUser().getStudent_id();
            ps.setString(1, student_id);
            ResultSet rs = ps.executeQuery();
            
            double totalPenalty = 0;
            while(rs.next()) {
                double penalty = rs.getDouble("penalty");
                totalPenalty += penalty;
            }
               
            String updateQuery = "UPDATE users SET penalty = ? WHERE student_id = ?";
            PreparedStatement ps1 = c.prepareStatement(updateQuery);
            ps1.setDouble(1, totalPenalty);
            ps1.setString(2, student_id);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void addBookPenalty() {
        ConnDB con = ConnDB.getInstance();
        Connection c = con.getConnection();
        
        String selectQuery = "SELECT * FROM borrowed_books AS bb INNER JOIN books ON bb.book_id = books.book_id WHERE bb.returned_at IS NULL AND CURDATE() > bb.due_date";
        
        try {
            PreparedStatement ps = c.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                LocalDate dueDate = rs.getObject("due_date", LocalDate.class);
                
                LocalDate curDate = LocalDate.now();
                long overdueDays = ChronoUnit.DAYS.between(dueDate, curDate);
                
                if(overdueDays > 0) {
                    double penalty = overdueDays * 200;
                    
                    String updateQuery = "UPDATE borrowed_books SET penalty = ? WHERE id = ?";
                    PreparedStatement ps1 = c.prepareStatement(updateQuery);
                    ps1.setDouble(1, penalty);
                    ps1.setInt(2, id);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "The book titled " + title + " is overdue. Please return it as soon as possible to avoid further penalties.", "Penalty Updated" , JOptionPane.WARNING_MESSAGE);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
   
}
