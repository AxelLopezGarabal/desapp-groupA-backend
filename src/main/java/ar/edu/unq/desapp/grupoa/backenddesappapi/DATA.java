package ar.edu.unq.desapp.grupoa.backenddesappapi;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.Product;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedCash;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedLocality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.TimesInTheMonth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DATA{

    public Locality locality = new Locality("L1", "province", 200, 20.0);
    public Locality locality1 = new Locality("L2", "province", 250, 25.0);

    public Project projectA = new Project("P1", 9000.0, "FP1", LocalDate.now(), LocalDate.now(), locality);
    public Project projectB = new Project("P2", 8000.0, "FP2", LocalDate.now(), LocalDate.now(), 2000.0, locality1);

    public Donation donation = new Donation(200.0, "nickname", projectA);

    public InvertedLocality forLocality = new InvertedLocality();
    public InvertedCash forCash = new InvertedCash();
    public TimesInTheMonth forTimes = new TimesInTheMonth();

    public List<IRule> lsRules(){
        return new ArrayList<>();
    }

    public Product product = new Product("name", 0.0, "/img", 0);

    public List<Product> lsProduct(){
        return new ArrayList<>();
    }

    public PunctuationSystem system(){
        return new PunctuationSystem();
    }
}