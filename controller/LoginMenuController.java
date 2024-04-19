package controller;

import enums.Menu;
import enums.RegisterValidPatterns;
import model.*;

import java.util.regex.Matcher;

public class LoginMenuController {
    public String register(String username, String password, String email){
        Matcher matcher;

        // Username errors
        if(isUsernameUnique(username) == false){
            return "username already exists";
        }
        if((matcher = RegisterValidPatterns.UserName.getMather(username)) == null){
            return "username format is invalid";
        }

        // Password errors
        if((matcher = RegisterValidPatterns.PasswordLength.getMather(password)) == null){
            return "password length too small or short";
        }
        if((matcher = RegisterValidPatterns.PasswordSpecialCharacter.getMather(password)) == null){
            return "your password must have at least one special character";
        }
        if((matcher = RegisterValidPatterns.PasswordWithEnglishCharacter.getMather(password)) == null){
            return "your password must start with english letters";
        }

        // Email errors
        if((matcher = RegisterValidPatterns.EmailAddress.getMather(email)) == null){
            return "email format is invalid";
        }
        if((matcher = RegisterValidPatterns.EmailWrongSpecialCharacter.getMather(email)) != null){
            return "you can't use special characters";
        }

        App.users.add(new User(username,password,email));
        return "user registered successfully";
    }

    public String login(String username, String password){
        User user = User.getUserByUsername(username);

        if(user == null){
            return "username doesn't exist";
        }
        if(!(user.getPassword().equals(password))){
            return "password is incorrect";
        }

        App.setCurrentMenu(Menu.MainMenu);
        App.setLoggedInUser(user);
        return "user logged in successfully";
    }

    public void exit(){
        App.setCurrentMenu(Menu.ExitMenu);
    }

    private boolean isUsernameUnique(String username){
        if(User.getUserByUsername(username) != null){
            return false;
        }
        return true;
    }

}
