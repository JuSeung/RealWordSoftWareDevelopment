package main;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import main.chapter02.BankTransaction;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0d;
        for (BankTransaction banktransaction: bankTransactions) {
            if (banktransaction.getDate().getMonth() == month) {
                total += banktransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0d;
        for (BankTransaction banktransaction: bankTransactions) {
            if (banktransaction.getDescription().equals(category)) {
                total += banktransaction.getAmount();
            }
        }
        return total;
    }

}
