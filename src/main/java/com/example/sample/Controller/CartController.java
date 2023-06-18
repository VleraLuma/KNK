package com.example.sample.Controller;

import com.example.sample.Class.CartEntry;
import com.example.sample.Main;
import com.example.sample.Class.ShoppingCart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class CartController {

    @FXML
    private VBox cartPane;

    private Label totalPriceLabel;

    @FXML
    public void initialize() throws FileNotFoundException {
        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        if (entries.isEmpty()){
            Label emptyLabel = new Label("Empty Cart!");
            cartPane.getChildren().add(emptyLabel);
        }else{
            Label shoppingCartTitle = new Label("Shopping Cart");
            cartPane.getChildren().add(shoppingCartTitle);

            for (CartEntry cartEntry:entries){
                HBox productName = cartEntryView(cartEntry);
                cartPane.getChildren().add(productName);
            }

            Separator separator = new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(separator);

            HBox totalView = totalView(ShoppingCart.getInstance().calculateTotal());
            cartPane.getChildren().add(totalView);
        }
    }
    private HBox totalView(double totalPrice){
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);

        Label totalLabel = new Label("Total:â‚¬ ");
        totalLabel.setStyle("-fx-font-sixe:15pt;");

        this.totalPriceLabel = new Label(String.valueOf(totalPrice));

        Button checkOutButton = new Button("Check out");
        checkOutButton.setAlignment(Pos.CENTER_LEFT);
        checkOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkout.fxml"));
                    Stage registerStage = new Stage();
                    Scene scene = new Scene(fxmlLoader.load(), 600, 500);
                    registerStage.initStyle(StageStyle.UNDECORATED);
                    registerStage.setScene(scene);
                    registerStage.show();

                }catch (Exception e){
                    e.printStackTrace();
                    e.getCause();
                }
            }
        });


        layout.getChildren().addAll(totalLabel,this.totalPriceLabel,checkOutButton);



        return layout;
    }


    private  HBox cartEntryView(CartEntry cartEntry) throws FileNotFoundException{
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\sample\\src\\main\\resources\\"+cartEntry.getProduct().getImageFile());
