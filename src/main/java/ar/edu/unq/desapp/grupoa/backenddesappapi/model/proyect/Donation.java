package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import java.time.LocalDate;
import java.time.Month;

public class Donation {
    private Long id;
    private Double amount;
    private String nickname;
    private Project project;
    private LocalDate date;


    public Donation(Long id, Double amount, String nickname, Project project) {
        this.id = id;
        this.amount = amount;
        this.nickname = nickname;
        this.project = project;
        this.date = LocalDate.now();
    }

    public Donation(Double amount, String nickname, Project project) {
        this.amount = amount;
        this.nickname = nickname;
        this.project = project;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return this.id;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Project getProject() {
        return this.project;
    }

    public void setAmount(Double newAmount) {
        this.amount = newAmount;
    }

    public void setNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void setProject(Project newProject) {
        this.project = newProject;
    }

    public void sendToProject(Project project) {
        project.receiveNewDonation(this);
    }

    public boolean amountIsGreaterThen(double amount) {
        return this.amount > amount;
    }

    public boolean populationOfProjectIsLessThen(Integer population) {
        return (this.project.getPopulationOfLocality()) < population;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate newDate){
        this.date = newDate;
    }

    public boolean isOfThisMonth(Month month) {
        return this.getDate().getMonth() == month;
    }

    public boolean isOfThisYear(int year) {
        return this.getDate().getYear() == year;
    }
}
