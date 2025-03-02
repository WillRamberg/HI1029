package com.example.hi1029.F9.NB27;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/com/example/hi1029/F9/NB27/cars.txt"));
            ArrayList<Car> cars = new ArrayList<>();
            while(true){
                String line = in.readLine();
                if(line == null)
                    break;
                var data = line.split(" ");
                String model = data[0];
                int modelYear = Integer.parseInt(data[1]);
                int milage = Integer.parseInt(data[2]);

                cars.add(new Car(model, modelYear, milage));
            }
            System.out.println(cars);
            cars.sort(new CompareCar());
            System.out.println(cars);
            saveToFile(cars);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void saveToFile(ArrayList<Car> cars){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/java/com/example/hi1029/F9/NB27/carsSorted.txt"));
            for (Car car : cars) {
                String carStr = car.getCarBrand() + " " + car.getYear() + " " + car.getMilage();
                out.write(carStr);
                out.newLine();
            }
            out.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
