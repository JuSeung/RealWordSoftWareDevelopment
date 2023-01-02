package main.chapter02.srp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import main.chapter02.BankStatementCSVParser;
import main.chapter02.BankTransaction;

public class BankTransctionAnalyzerSRP {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final String fileName = args[0];
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        System.out.println("The total for all transactions is " + calulateTotalAmount(bankTransactions));
        System.out.println("The total for all transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));

    }

    public static double calulateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction banktransaction: bankTransactions) {
            if (banktransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(banktransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
