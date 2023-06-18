package com.example.sample.Class;

public enum Product {

    Airconditioner("com/example/sample/Images/Airconditioner.jpg",499.99),
    Airpods("com/example/sample/Images/Airpods.jpg",149.99),
    Calculator("com/example/sample/Images/Calculator.jpg",49.99),
    Hairdryer("com/example/sample/Images/Hairdryer.jpg",40),
    Headphone("com/example/sample/Images/Headphone.jpg",250),
    iPad("com/example/sample/Images/iPad.jpg", 349.99),
    Iphone("com/example/sample/Images/Iphone.jpg",600),
    Laptop("com/example/sample/Images/laptop.jpg", 500),
    SmartWatch("com/example/sample/Images/SmartWatch.jpg",349.99),
    Televison("com/example/sample/Images/Television.jpg",750);

    private String imageFile;
    private double price;

    private Product(String imageFile, double price){
        this.imageFile = imageFile;
        this.price = price;
    }
    public String getImageFile(){
        return imageFile;
    }

    public double getPrice() {
        return price;
    }
}
