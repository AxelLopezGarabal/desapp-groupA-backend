package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody;

public class DonationRequestBody {

    private Integer projectId;
    private Double amount;

    public DonationRequestBody(){}

    public DonationRequestBody(Integer projectId, Double amount) {
        this.projectId = projectId;
        this.amount = amount;
    }


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
