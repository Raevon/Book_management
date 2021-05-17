package lt.viko.eif.ddziekvicius.book_management.Library;

import lt.viko.eif.ddziekvicius.book_management.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * class that operates with user/s
 */
public class UserRepo {
    private static List<User> userList;
    private static User loggedInUser;

    public UserRepo(){
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(new User("Adam","Traore",12345));

}

    public void Login(String nickName, int password) throws Exception {
        loggedInUser = null;
        for (User u : userList){

            if(u.getName().equals(nickName) && u.getPassword()==(password)){
                loggedInUser=u;
                System.out.println(u);
                break;
            }
        }
        if (loggedInUser == null){
            throw new Exception("wrong credentials");
        }
    }
    public User GetLoggedInUser ()
    {
        return loggedInUser;
    }
}
