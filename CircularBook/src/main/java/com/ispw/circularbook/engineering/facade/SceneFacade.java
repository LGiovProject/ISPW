package com.ispw.circularbook.engineering.facade;


import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SceneFacade {

    private final AnchorPane anchorPaneB;

    public SceneFacade(AnchorPane anchorPaneB) {
        this.anchorPaneB = anchorPaneB;
    }

    public void loadScene(Pane pane)
    {
            loadFXML(pane);
    }


    private void loadFXML(Pane pane) {
        try {
            anchorPaneB.getChildren().clear();
            anchorPaneB.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
