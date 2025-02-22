package model;

public class Current_User {
    private static User_Model currentUser;
    
    
    private Current_User() {};
    
    public static void setCurrentUser(User_Model user) {
        currentUser = user;
    }
    
    public static User_Model getCurrentUser() {
        return currentUser;
    }
}
