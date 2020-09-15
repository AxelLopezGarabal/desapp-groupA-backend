package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedCash;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedLocality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.TimesInTheMonth;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

class PunctuationSystemTest {

    private PunctuationSystem punctuationSystem;
    private List<IRule> listOfRules = new ArrayList<>();

    @BeforeEach
    void setUp() {
        punctuationSystem = new PunctuationSystem(listOfRules);
    }

    @AfterEach
    void tearDown() {
        punctuationSystem = null;
    }

    @Test
    public void test01WhenAPunctuationSystemReceivesTheMessageGetRulesRespondsWithItsListOfRules(){
        assertEquals(punctuationSystem.getRules(), listOfRules);
    }

    @Test
    public void test02WhenAPunctuationSystemReceivesTheMessageSetRulesChangesItListOfRules(){
        List<IRule> newListOfRules = new ArrayList<>();

        punctuationSystem.setRules(newListOfRules);

        assertEquals(punctuationSystem.getRules(), newListOfRules);
    }

    @Test
    public void test03WhenAPunctuationSystemReceivesTheMessageAddRuleThatIsInvertedCashItAddsTheRuleToTheListOfRules(){
        InvertedCash newRule = mock(InvertedCash.class);
        punctuationSystem.addRule(newRule);

        assertEquals(punctuationSystem.getRules().get(0), newRule);
    }

    @Test
    public void test04WhenAPunctuationSystemReceivesTheMessageAddRuleThatIsInvertedLocalityItAddsTheRuleToTheListOfRules(){
        InvertedLocality newRule = mock(InvertedLocality.class);
        punctuationSystem.addRule(newRule);

        assertEquals(punctuationSystem.getRules().get(0), newRule);
    }

    @Test
    public void test05WhenAPunctuationSystemReceivesTheMessageAddRuleThatIsTimeInMonthItAddsTheRuleToTheListOfRules(){
        TimesInTheMonth newRule = mock(TimesInTheMonth.class);
        punctuationSystem.addRule(newRule);

        assertEquals(punctuationSystem.getRules().get(0), newRule);
    }
}