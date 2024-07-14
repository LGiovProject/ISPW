package com.ispw.circularbook.engineering.state.gui;

import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;

import java.io.IOException;

public interface GUIHomepageState {
    void startHomepage(GUIHomepageController context) throws IOException;
    void setting(GUIHomepageController context) throws IOException ;
}
