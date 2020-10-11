package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

public class UserBodyPost {
    private String name;
    private String nickname;
    private String email;
    private String password;

    public UserBodyPost(String name, String nickname, String email, String password){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public User setValues(User user) throws MailValidation {
        user.setName(this.name);
        user.setNickname(this.nickname);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
