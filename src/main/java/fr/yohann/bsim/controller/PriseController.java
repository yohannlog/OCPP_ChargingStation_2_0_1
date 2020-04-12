package fr.yohann.bsim.controller;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class PriseController implements Initializable {

 //   private ObjectProperty<OutletState> outletState = new SimpleObjectProperty<>();

    @FXML
    private RadioButton noDispo;
    @FXML
    private RadioButton inCharge;
    @FXML
    private RadioButton free;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      //  noDispo.getProperties().put("state", OutletState.NO_DISPO);
       // inCharge.getProperties().put("state", OutletState.IN_CHARGE);
        //free.getProperties().put("state", OutletState.FREE);

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(free, noDispo, inCharge);

     /**   outletState.addListener((observableValue, outletState1, t1) -> {
            if (t1 != null) {
                group.getToggles()
                        .stream()
                        .filter( (rb) -> rb.getProperties().get("state").equals(t1))
                        .forEach(group::selectToggle);
            }
        });**/


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // outletState.set(OutletState.IN_CHARGE);
    }
}
