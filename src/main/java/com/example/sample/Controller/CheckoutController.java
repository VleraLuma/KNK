package com.example.sample.Controller;

import com.example.sample.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class CheckoutController {
    @FXML
    private Button BuyButton;
    @FXML
    private Button CancelButton;
    @FXML
    private TextField CardNumberField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField ExpiryDateField;
    @FXML
    private TextField CvvField;
    @FXML
    private Label PaymentLabel;

    public void BuyButtonOnAction(ActionEvent e){
        if (CardNumberField.getText().isBlank()==false && NameField.getText().isBlank()==false && ExpiryDateField.getText().isBlank()==false && CvvField.getText().isBlank()==false){
            registerPayment();
            PaymentLabel.setText("Payment has been successfully done!");
        }else {
            PaymentLabel.setText("Please fill all fields!");
        }
    }

    public void CancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerPayment(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String CardNumber = CardNumberField.getText();
        String Name = NameField.getText();
        String ExpiryDate = ExpiryDateField.getText();
        String CVV = CvvField.getText();

        String insertFields = "Insert into payments(CardNumber, Name, ExpiryDate, CVV) VALUES ('";
        String insertValues = CardNumber +"','"+ Name +"','"+ ExpiryDate + "','"+ CVV + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
