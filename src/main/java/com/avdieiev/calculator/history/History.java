package com.avdieiev.calculator.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class History implements HistoryInterface {
    List<String> fullHistory = new ArrayList<>();

    /**
     * Saves the expression entered by the user and its result.
     * @param savingElement - element for saving.
     */
    @Override
    public void save(String savingElement) {
        fullHistory.add(savingElement);
    }

    /**
     * Returns the complete history of calculations.
     */
    @Override
    public String getAll() {
        return fullHistory.toString();
    }

    /**
     * Returns the history of unique calculations.
     */
    @Override
    public String getUnique() {
        Set<String> historyUnique = new HashSet<>(fullHistory);
        return historyUnique.toString();
    }
}
