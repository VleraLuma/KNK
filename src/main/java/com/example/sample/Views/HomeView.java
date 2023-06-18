package com.example.sample.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.net.URL;

public class HomeView {

    private Parent view;

    public HomeView() throws Exception{
        URL url = new File("C:\\Users\\Admin\\eclipse-workspace\\sample\\src\\main\\resources\\com\\example\\sample\\home.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        this.view = root;
    }
    public Parent getView(){
        return view;
    }
}
