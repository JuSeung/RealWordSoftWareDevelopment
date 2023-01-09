package main.chapter02.parser;

import java.util.List;
import main.chapter02.BankTransaction;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
