package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;

public interface CLIManageState {

    void start();
    void command(String i) throws CommandNotFoundException;
    void manageMyAvailableBook();
    void showBookIGive();
}
