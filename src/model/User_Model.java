package model;

import java.time.LocalDateTime;

public class User_Model {
    
    private String student_id, first_name, last_name, email, password;
//    private Enum role;
    private double penalty;
    private LocalDateTime created_at;
    
    public static String role = "User";
    
}
