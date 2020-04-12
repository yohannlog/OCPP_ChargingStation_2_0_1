package fr.yohann.bsim.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import fr.yohann.bsim.Main;
import fr.yohann.bsim.OCPPWebSocket;
import fr.yohann.bsim.messages.BootNotificationRequest;
import fr.yohann.bsim.messages.BootNotificationResponse;
import fr.yohann.bsim.messages.Test;
import fr.yohann.bsim.types.LocationEnumType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class DashboardController implements Initializable{

    @FXML
    private JFXButton sendButton;
    @FXML
    private TextField ipField, portField, nomBorne;

    private WebSocket ws;

    @FXML
    private HBox prises;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            final Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

            FXMLLoader loader = Main.loadAFXML("menu/prise.fxml");
            sendButton.setOnAction(actionEvent -> {
                if (ipField.getText().isEmpty()) return;
                if (!ipField.getText().matches(pattern.pattern())) return;
                ws = HttpClient.newHttpClient()
                        .newWebSocketBuilder()
                        .subprotocols("ocpp2.0.1j")
                        .buildAsync(URI.create("ws://" + ipField.getText() + ":" + portField.getText() + "/Simulateur/" + nomBorne.getText() + "/"), new OCPPWebSocket()).join();

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
