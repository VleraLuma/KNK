package com.example.sample.Controller;

import com.example.sample.Views.CartView;
import com.example.sample.Views.HomeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class AppController {

    @FXML
    private Button backButton;
    @FXML
    BorderPane contentPane;

    public void closeApp(ActionEvent e) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    public void showHomeView() throws Exception{
        contentPane.setCenter(new HomeView().getView());

    }

    public void showCartView() throws IOException {
        contentPane.setCenter(new CartView().getView());
    }
}
