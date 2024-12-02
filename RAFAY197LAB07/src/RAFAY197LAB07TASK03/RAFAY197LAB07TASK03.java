//ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 01:
package RAFAY197LAB07TASK03;
import java.util.*;
public class RAFAY197LAB07TASK03 {
    static class Car {
        private String id;
        private String model;
        private long price;
        private String status;
        private int year; // New attribute for car year
        public Car(String id, String model, long price, int year) {
            this.id = id;
            this.model = model;
            this.price = price;
            this.status = "available"; // Status for sale
            this.year = year; // Initialize car year
        }
        public String getId() {
            return id;
        }
        public String getModel() {
            return model;
        }
        public long getPrice() {
            return price;
        }
        public String getStatus() {
            return status;
        }
        public int getYear() { // New method to get car year
            return year;
        }
        public void setStatus(String status) {
            this.status = status;
        }
    }
    static class Service {
        private String serviceId;
        private String carId; // Optional, can be null if not related to a sale car
        private String serviceType;
        private long charge;
        private Date serviceDate;
        public Service(String serviceId, String carId, String serviceType, long charge, Date serviceDate) {
            this.serviceId = serviceId;
            this.carId = carId;
            this.serviceType = serviceType;
            this.charge = charge;
            this.serviceDate = serviceDate;
        }
        public String getServiceId() {
            return serviceId;
        }
        public String getCarId() {
            return carId;
        }
        public String getServiceType() {
            return serviceType;
        }
        public long getCharge() {
            return charge;
        }
        public Date getServiceDate() {
            return serviceDate;
        }
    }
    static class CarShowroom {
        private Map<String, Car> cars = new HashMap<>();
        private List<Service> services = new ArrayList<>();
        public void addCar(String id, String model, long price, int year) { // Updated method
            cars.put(id, new Car(id, model, price, year));
        }
        public List<Car> getAvailableCars() {
            List<Car> availableCars = new ArrayList<>();
            for (Car car : cars.values()) {
                if ("available".equals(car.getStatus())) {
                    availableCars.add(car);
                }
            }
            return availableCars;
        }
        public void scheduleService(String serviceId, String carId, String serviceType, long charge, Date serviceDate) {
            services.add(new Service(serviceId, carId, serviceType, charge, serviceDate));
            if (cars.containsKey(carId)) {
                cars.get(carId).setStatus("in service"); // Change status if car is in service
            }
        }
        public List<Service> getCurrentServices() {
            return services;
        }
        public void displayAvailableCars() {
            System.out.println("\n(*): Cars Available for Sale:");
            for (Car car : getAvailableCars()) {
                System.out.println("Model: " + car.getModel() + 
                                   ", Year: " + car.getYear() + // Display car year
                                   ", Price: Rs" + car.getPrice());
            }
            System.out.println(); // New line for clarity
        }
        public void displayServiceDetails() {
            System.out.println("(*): Available Services:");
            for (Service service : services) {
                String carModel = service.getCarId() != null ? cars.get(service.getCarId()).getModel() : "N/A";
                System.out.println("\nService ID: " + service.getServiceId() +
                                   ": \nCar Model: " + carModel +
                                   ", Service Type: '" + service.getServiceType() +
                                   "', Charge: Rs" + service.getCharge() +
                                   ", Service Date: " + service.getServiceDate());
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            CarShowroom showroom = new CarShowroom();
            System.out.println("ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 01:\n");
            System.out.println("(*): SCENARIO: Car Showroom & Services (Cars Dealing and Service Centre - Regarding Car Maintenance & Services):");
            System.out.println("(*): OBJECTIVE: Implement Good Code Practices and Optimization Techniques:");
            // Adding cars
            showroom.addCar("1", "Toyota Camry", 24000000, 2015);
            showroom.addCar("2", "Honda Accord", 17000000, 2017);
            showroom.addCar("3", "Suzuki Swift", 2650000, 2021);
            showroom.addCar("4", "Toyota Prado", 45000000, 2018);
            showroom.addCar("5", "Toyota Surf", 4500000, 2008);
            showroom.addCar("6", "Honda Civic", 5800000, 2020);
            showroom.addCar("7", "Toyota Aqua", 3650000, 2017);
            showroom.addCar("8", "Honda Freed", 4600000, 2016);          
            // Scheduling services
            showroom.scheduleService("S1", "1", "Oil Change", 10000, new Date());
            showroom.scheduleService("S2", "8", "Car Wash", 1000, new Date()); 
            showroom.scheduleService("S3", "3", "Wheel Alignment", 2500, new Date());
            showroom.scheduleService("S4", "5", "General Maintainence", 12500, new Date());            
            // Displaying available cars for sale
            showroom.displayAvailableCars();          
            // Displaying service details
            showroom.displayServiceDetails();
        }
    }
}

