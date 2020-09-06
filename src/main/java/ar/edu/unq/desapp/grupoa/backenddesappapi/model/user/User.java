package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

import java.util.List;

public class User {
    private String name;
    private String nickname;
    private String email;
    private String password;
    private List<Donation> donations;
    private Wallet wallet;

    public User(String name, String nickname, String email, String password, List<Donation> donations, Wallet wallet) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.donations = donations;
        this.wallet = wallet;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Donation> getDonations() {
        return this.donations;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setWallet(Wallet newWallet) {
        this.wallet = newWallet;
    }

    public void addDonation(Donation aDonation) {
        this.donations.add(aDonation);
    }
}
