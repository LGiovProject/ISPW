package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;

import java.io.IOException;

public interface CLIHomepageState {
    void startHomepage();
    void setting() throws IOException ;
    void logOut();
    void command(String i) throws CommandNotFoundException;
}
