package chapter2;

import java.time.LocalDate;
import java.util.Objects;

// 단일 책임 원칙 SRP 적용
// 입출금 내역을 표현하는 도메인 클래스
// 도메인 클래스란?
// 소프트웨어 개발에서 특정 도메인(영역)에 속하는 데이터를 표현하고, 해당 데이터와 관련된 비즈니스 로직을 포함하는 클래스
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{ " +
                "date = " + date +
                ", amount = " + amount +
                ", description = '" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
