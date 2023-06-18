package com.example.sample.Controller;

import com.example.sample.Class.Product;
import com.example.sample.Class.ShoppingCart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {
    @FXML
    private GridPane productGridPane;
    @FXML
    public void initialize() throws FileNotFoundException {
        productGridPane.getChildren().clear();

        VBox productView1 = productView(Product.Airconditioner);
        productGridPane.add(productView1,0,0);


        VBox productView2 = productView(Product.Airpods);
        productGridPane.add(productView2,1,0);


        VBox productView3 = productView(Product.Calculator);
        productGridPane.add(productView3,2,0);


        VBox productView4 = productView(Product.Hairdryer);
        productGridPane.add(productView4,0,1);


        VBox productView5 = productView(Product.Headphone);
        productGridPane.add(productView5,1,1);


        VBox productView6 = productView(Product.iPad);
        productGridPane.add(productView6,2,1);


        VBox productView7 = productView(Product.Iphone);
        productGridPane.add(productView7,0,2);


        VBox productView8 = productView(Product.Laptop);
        productGridPane.add(productView8,1,2);


        VBox productView9 = productView(Product.SmartWatch);
        productGridPane.add(productView9,2,2);


        VBox productView10 = productView(Product.Televison);
        productGridPane.add(productView10,0,3);

    }
    public VBox productView(Product product) throws FileNotFoundException {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        FileInputStream input = new FileInputStream("\\Users\\Admin\\eclipse-workspace\\sample\\src\\main\\resources\\"+product.getImageFile());

        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);

        Label productName = new Label(product.name());
        Label price = new Label(product.getPrice()+ "€");

        Button addButton = new Button("Add to Cart");
        addButton.setUserData(product.name());
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Node sourceComponent = (Node)actionEvent.getSource();
                String productName = (String)sourceComponent.getUserData();
                ShoppingCart shoppingCart = ShoppingCart.getInstance();
                shoppingCart.addProducts(productName);

            }
        });

        layout.getChildren().addAll(imageView,productName,price,addButton);

        return layout;
    }



}
