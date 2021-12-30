package com.avdieiev.calculator.history;

public interface HistoryInterface {

    /**
     * Describes all possible actions with history.
     */
    void save(String savingElement);

    String getAll();

    String getUnique();
}
