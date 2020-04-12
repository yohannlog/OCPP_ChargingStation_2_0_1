package fr.yohann.bsim;

import fr.yohann.bsim.utils.Configuration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = loadFXML("mainMenu");
        Parent homeWindow = loader.load();
        Stage dashboardStage = new Stage();

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        dashboardStage.setWidth(screenBounds.getWidth() * 0.83);
        dashboardStage.setHeight(screenBounds.getHeight() * 0.74);

        dashboardStage.getIcons().add(new Image(getClass().getResource("/assets/Logo.png").toExternalForm()));
        dashboardStage.setScene(new Scene(homeWindow));
        dashboardStage.setTitle("Manage");
        dashboardStage.show();
    }

    public static void main(String[] args) {
        Configuration configuration = Configuration.getInstance();
        Configuration.updateProperties();
        launch();

    }

    private static FXMLLoader loadFXML(String fxml)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/menu/HomeWindow.fxml"));
        return fxmlLoader;
    }

    public static FXMLLoader loadAFXML(String fxml)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader;
    }
}