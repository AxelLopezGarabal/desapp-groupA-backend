package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class PunctuationSystem {
    private Long id;
    private List<Product> products;
    private List<IRule> rules;

    public PunctuationSystem(List<IRule> listOfRules, List<Product> productList) {
        this.rules = listOfRules;
        this.products = productList;
    }

    public PunctuationSystem(Long id, List<IRule> listOfRules, List<Product> productList) {
        this.id = id;
        this.rules = listOfRules;
        this.products = productList;
    }

    /** METHODS RELATED TO THE PRODUCTS **/
    public void addProduct(Product newProduct) {
        this.products.add(newProduct);
    }

    public void deleteProduct(Product newProduct) {
        this.products.remove(newProduct);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProductList(List<Product> newListOfProduct) {
        this.products = newListOfProduct;
    }

    /** METHODS RELATED TO THE RULES **/

    public List<IRule> getRules() {
        return this.rules;
    }

    public void setRules(List<IRule> newListOfRules) {
        this.rules = newListOfRules;
    }

    public void addRule(IRule newRule) {
        this.rules.add(newRule);
    }

    public void deleteRule(IRule newRule) {
        this.rules.remove(newRule);
    }

    /** METHODS RELATED TO THE DONATIONS **/

    public List<IRule> rulesApplicableToDonation(Donation aDonation, User user) {
        return this.rules.stream().filter(rule -> rule.isApplicable(aDonation, user)).collect(Collectors.toList());
    }

    public Double pointsGainForDonation(Donation aDonation, User user) {
        return this.rulesApplicableToDonation(aDonation, user).stream().mapToDouble(rule -> rule.pointsForDonation(aDonation, user)).sum();
    }

    public Double amountOfPointsForDonations(List<Donation> donations, User user) {
        return donations.stream().mapToDouble(donation -> this.pointsGainForDonation(donation, user)).sum();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }
}
