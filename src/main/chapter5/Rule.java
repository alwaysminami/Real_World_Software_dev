package main.chapter5;

@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}
