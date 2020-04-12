package fr.yohann.bsim.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class Prise extends VBox
{
    public long transactionId = 0;
    public short idConnecteur;
   // public ConnectorStatusEnumType status;
    public int consommation;
    public String authenticationCode;

    public Prise() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/prise.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
