package main.chapter5;

public class RuleBuilder {
    private Condition condition;

    private RuleBuilder(final Condition condition) {
        this.condition = condition;
    }

    public static RuleBuilder when(final Condition condition) {
        return new RuleBuilder(condition);
    }

    public DefaultRule then(final Action action) {
        return new DefaultRule(condition, action);
    }
}
