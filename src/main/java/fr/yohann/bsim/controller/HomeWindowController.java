package fr.yohann.bsim.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeWindowController implements Initializable {

    @FXML
    private StackPane homeWindowSP, dashboardContainer;
    @FXML
    private SplitPane splitPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

           /* FXMLLoader historyLoader = new FXMLLoader(getClass().getResource("/menu/HistoryPane.fxml"));
            Parent historyFXML = historyLoader.load();
            splitPane.getItems().add(0, historyFXML);*/
            FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("/menu/Dashboard.fxml"));
            Parent dashFXML = dashLoader.load();
            dashboardContainer.getChildren().add(dashFXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
