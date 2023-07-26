package main.chapter3;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

// BankStatementProcessor 클래스의 계산 연산 그룹화
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    // 특정 금액 이상의 은행 거래 내역 찾기
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    // 특정 월의 입출금 내역 찾기
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    // 특정 월이나 금액으로 입출금 내역 검색하기
    // 아래와 같이 거래 내역의 여러 속성을 조합할수록 코그다 점점 복잡해짐
    // 반복 로직과 비즈니스 로직이 결합되어 분리하기가 어려워짐
    // 이럴 때 개방/폐쇄 원칙을 적용
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions) {
           if(bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
               result.add(bankTransaction);
           }
        }
        return result;
    }
}
