package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    private Long userId;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private List<Donation> donations;
    private Wallet wallet;

    public User(String name, String nickname, String email, String password, Wallet wallet) throws MailValidation {
        validateEmail(email);
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.donations = new ArrayList<>();
        this.wallet = wallet;
    }

    public User(Long id, String name, String nickname, String email, String password, Wallet wallet) throws MailValidation {
        validateEmail(email);
        this.userId = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
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

    public void setEmail(String newEmail) throws MailValidation {
        validateEmail(newEmail);

        this.email = newEmail;
    }

    private void validateEmail(String email) throws MailValidation {
        Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL.matcher(email);

        if(!matcher.find()) {
            throw new MailValidation();
        }
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

    public void createADonation(Double amount, Project project) {
        Donation newDonation = new Donation(amount, this.nickname, project);
        this.donations.add(newDonation);
        this.wallet.gainPointsForDonation(newDonation, this);
        newDonation.sendToProject(project);
    }

    public Double getPoints() {
        return this.wallet.getPoints();
    }

    public List<Donation> getDonationsOfTheMonth() {
        return this.donations.stream().filter(donation -> this.isOfValidDate(donation)).collect(Collectors.toList());
    }

    public boolean isOfValidDate(Donation donation) {
        return this.isDonationOfThisMonth(donation) && this.isDonationOfThisYear(donation);
    }

    public boolean isDonationOfThisYear(Donation donation) {
        return donation.isOfThisYear(LocalDate.now().getYear());
    }

    public boolean isDonationOfThisMonth(Donation donation) {
        return donation.isOfThisMonth(LocalDate.now().getMonth());
    }

    public Long getId() {
        return this.userId;
    }

    public void setId(long l) {
        this.userId = l;
    }
}
