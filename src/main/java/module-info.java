module OCPPJ.Borne {
    requires com.jfoenix;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.net.http;
    requires com.google.gson;

    opens fr.yohann.bsim to javafx.graphics;
    opens fr.yohann.bsim.controller to javafx.fxml;

    opens fr.yohann.bsim.utils to com.google.gson;
}