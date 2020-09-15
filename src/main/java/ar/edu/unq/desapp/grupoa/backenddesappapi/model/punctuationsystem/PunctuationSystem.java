package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

import java.util.List;

public class PunctuationSystem {
    private List<IRule> rules;

    public PunctuationSystem(List<IRule> listOfRules) {
        this.rules = listOfRules;
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

    /** METHODS RELATED TO THE DONATIONS **/

    public Double calculatePointsForDonation(Donation aDonation) {
        return 0.0;
    }
}
