package main.chapter5;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    private final List<DefaultRule> rules;
    private final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        this.rules = new ArrayList<DefaultRule>();
        this.facts = facts;
    }

    public void addRule(DefaultRule rule) {
        this.rules.add(rule);
    }

    public void run() {
        this.rules.forEach(action -> action.perform(facts));
    }
}
