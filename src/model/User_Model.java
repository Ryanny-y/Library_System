package model;

import java.time.LocalDateTime;

public class User_Model {

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
    
    private String student_id, first_name, last_name, email, password;
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
    
    public User_Model(String student_id, String first_name, String last_name, String email, String password, String role, double penalty, LocalDateTime joined_at) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.role = convertRole(role);
        this.penalty = penalty;
        this.joined_at = joined_at;
    }
    
    private User_Role convertRole(String dbRole) {
        return User_Role.valueOf(dbRole);
    }
   
}
