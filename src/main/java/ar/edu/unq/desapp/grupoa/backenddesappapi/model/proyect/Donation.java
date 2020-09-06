package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

public class Donation {
    private Long id;
    private Double amount;
    private String nickname;
    private Project project;


    public Donation(Long id, Double amount, String nickname, Project project) {
        this.id = id;
        this.amount = amount;
        this.nickname = nickname;
        this.project = project;
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
}
