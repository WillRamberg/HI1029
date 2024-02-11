package com.example.hi1029.F9.NB27;

public class Car implements Comparable<Car>{

    private String carBrand;
    private int modelYear;
    private int milage;

    public Car(String carBrand, int modelYear, int milage){
        this.carBrand = carBrand;
        this.modelYear = modelYear;
        this.milage = milage;
    }

    public String getCarBrand(){
        return this.carBrand;
    }

    public int getYear(){
        return this.modelYear;
    }

    public int getMilage(){
        return this.milage;
    }


    @Override
    public int compareTo(Car car) {
        return (car.carBrand.compareTo(this.carBrand));
    }

    @Override
    public String toString() {
        return "Model: " + carBrand +" Model year: " + modelYear + " Milage: " + milage + "\n";
    }
}
