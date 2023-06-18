package com.example.sample.Controller;

import com.example.sample.DatabaseConnection;
import com.example.sample.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField UsernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {
        //loginMessageLabel.setText("You try to login!");

        if (UsernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
//            loginMessageLabel.setText("You try to login!");
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password!");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) From UserAccounts WHERE username = '"+UsernameTextField.getText()+"' AND password = '"+passwordPasswordField.getText()+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    //loginMessageLabel.setText("Welcome!");
                    //createAccountForm();
                    homepage();
                }else {
                    loginMessageLabel.setText("Invalid Login.Please try again.");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 567);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void registerButtonOnAction(ActionEvent e ){
        createAccountForm();
    }

    public void homepage(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cartui.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 567);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
