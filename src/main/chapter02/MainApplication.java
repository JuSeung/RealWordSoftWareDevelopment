package main.chapter02;


import java.io.IOException;
import main.chapter02.coupling.BankStatementAnalyzer;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyzer(args[0], bankStatementCSVParser);
    }
}
