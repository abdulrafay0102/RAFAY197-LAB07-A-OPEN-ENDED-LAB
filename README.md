# RAFAY197-LAB07-A-OPEN-ENDED-LAB

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

//ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 02:
package RAFAY197LAB07TASK04;
import java.util.*;
public class RAFAY197LAB07TASK04 {
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
	    public void scheduleService(String serviceId, String carId, String serviceType, long charge, Date serviceDate) {
	        services.add(new Service(serviceId, carId, serviceType, charge, serviceDate));
	        if (cars.containsKey(carId)) {
	            cars.get(carId).setStatus("in service"); // Change status if car is in service
	        }
	    }
	    public void displayAvailableCars() {
	        System.out.println("(*): Cars Available for Sale:");
	        for (Car car : cars.values()) {
	            if ("available".equals(car.getStatus())) {
	                System.out.println("Model: " + car.getModel() + ", Price: $" + car.getPrice());
	            }
	        }
	    }
	    public void displayServiceDetails() {
	        System.out.println("Available Services:");
	        for (Service service : services) {
	            String carModel = service.getCarId() != null ? cars.get(service.getCarId()).getModel() : "N/A";
	            System.out.println("\nService ID: " + service.getServiceId() +
	                ", Car Model: " + carModel +
	                ", Service Type: '" + service.getServiceType() +
	                ",' Charge: $" + service.getCharge() +
	                ", Service Date: " + service.getServiceDate());
	        }
	    }
	    public long calculateTotalServiceRevenue() {
	        return services.stream().mapToLong(Service::getCharge).sum();
	    }
	}
	// Thread for calculations (e.g., calculating total sales and service revenue)
	static class CalculationThread extends Thread {
	    private CarShowroom showroom;
	    public CalculationThread(CarShowroom showroom) {
	        this.showroom = showroom;
	    }
	    @Override
	    public void run() {
	        try {
	            // Simulate some calculations
	            System.out.println("\n(*): Calculating total sales and service revenue...");
	            Thread.sleep(2000); // Simulate time taken for calculations
	            // Calculate total sales value (sum of all car prices)
	            long totalSales = showroom.cars.values().stream().mapToLong(Car::getPrice).sum();
	            // Calculate total service revenue
	            long totalServiceRevenue = showroom.calculateTotalServiceRevenue();
	            System.out.println("Total Sales Value: $" + totalSales);
	            System.out.println("Total Service Revenue: $" + totalServiceRevenue);
	        } catch (InterruptedException e) {
	            System.out.println("Calculation interrupted!");
	        }
	    }
	}
	// Thread for logging data (e.g., logging operations)
	static class LoggingThread extends Thread {
	    private CarShowroom showroom;
	    public LoggingThread(CarShowroom showroom) {
	        this.showroom = showroom;
	    }
	    @Override
	    public void run() {
	        try {
	            // Simulate logging of available cars
	            System.out.println("(*): Logging available cars...");
	            Thread.sleep(1000); // Simulate time taken for logging	            
	            showroom.displayAvailableCars();
	        } catch (InterruptedException e) {
	            System.out.println("Logging interrupted!");
	        }
	    }
	}
	public class Main {
	    public static void main(String[] args) {
	        CarShowroom showroom = new CarShowroom();
	        System.out.println("ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 02:\n");
            System.out.println("(*): SCENARIO: Car Showroom & Services (Cars Dealing and Service Centre - Regarding Car Maintenance & Services):");
            System.out.println("(*): NOTE: Displaying The Inventory And Calculating Total Revenue:");
            System.out.println("(*): OBJECTIVE: Concurrency with Multithreading Mechanisms:\n");
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
	        // Create threads for calculations and logging
	        CalculationThread calculationThread = new CalculationThread(showroom);
	        LoggingThread loggingThread = new LoggingThread(showroom);	        
	        // Start the logging thread first
	        loggingThread.start();        
	        try {
	            // Ensure logging completes before starting calculations
	            loggingThread.join(); // Wait for loggingThread to finish
	        } catch (InterruptedException e) {
	            System.out.println("Main thread interrupted while waiting for logging thread.");
	        }     
	        // Start the calculation thread
	        calculationThread.start();	        
	        try {
	            // Optionally wait for calculation to finish
	            calculationThread.join(); // Wait for calculationThread to finish
	        } catch (InterruptedException e) {
	            System.out.println("Main thread interrupted while waiting for calculation thread.");
	        }     
	        System.out.println("\nAll operations completed!!!!");
	    }
	}
}

//ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 03:
package RAFAY197LAB07TASK05;
import java.util.*;
public class RAFAY197LAB07TASK05 {
	static class Car {
	    private String id;
	    private String model;
	    private double price;
	    private String status;
	    public Car(String id, String model, double price) {
	        this.id = id;
	        this.model = model;
	        this.price = price;
	        this.status = "available"; // Status for sale
	    }
	    public String getId() {
	        return id;
	    }
	    public String getModel() {
	        return model;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	}
	static class Service {
	    private String serviceId;
	    private String serviceType; // Now contains actual service names
	    private double charge;
	    private Date serviceDate;
	    public Service(String serviceId, String serviceType, double charge, Date serviceDate) {
	        this.serviceId = serviceId;
	        this.serviceType = serviceType;
	        this.charge = charge;
	        this.serviceDate = serviceDate;
	    }
	    public String getServiceId() {
	        return serviceId;
	    }
	    public String getServiceType() {
	        return serviceType; // Return the service type
	    }
	    public double getCharge() {
	        return charge;
	    }
	    public Date getServiceDate() {
	        return serviceDate;
	    }
	}
	// Shared buffer for services
	static class ServiceBuffer {
	    private final List<Service> services = new ArrayList<>();
	    private final int capacity;
	    public ServiceBuffer(int capacity) {
	        this.capacity = capacity;
	    }
	    public synchronized void addService(Service service) throws InterruptedException {
	        while (services.size() == capacity) {
	            // Wait until there's space in the buffer
	            wait();
	        }
	        services.add(service);
	        System.out.println("Service Is Being Performed: " + service.getServiceType());
	        notify(); // Notify a waiting consumer
	    }
	    public synchronized Service removeService() throws InterruptedException {
	        while (services.isEmpty()) {
	            // Wait until there's a service to consume
	            wait();
	        }
	        Service service = services.remove(0);
	        System.out.println("Service Completed: " + service.getServiceType());
	        notify(); // Notify a waiting producer
	        return service;
	    }
	}
	// Producer thread that adds services to the buffer
	static class ProducerThread extends Thread {
	    private final ServiceBuffer buffer;
	    public ProducerThread(ServiceBuffer buffer) {
	        this.buffer = buffer;
	    }
	    @Override
	    public void run() {
	        try {
	            // Producing different specific services
	            String[] serviceNames = {"Oil Change", "Tuning", "Car Wash", "Wheel Alignment", "Brake Inspection"};
	            for (int i = 0; i < serviceNames.length; i++) {
	                Service service = new Service("S" + (i + 1), serviceNames[i], 50.0, new Date());
	                buffer.addService(service);
	                Thread.sleep(500); // Simulate time taken to produce a service
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
	// Consumer thread that processes services from the buffer
	static class ConsumerThread extends Thread {
	    private final ServiceBuffer buffer;
	    public ConsumerThread(ServiceBuffer buffer) {
	        this.buffer = buffer;
	    }
	    @Override
	    public void run() {
	        try {
	            // Consuming the same number of services as produced
	            for (int i = 1; i <= 5; i++) {
	                Service service = buffer.removeService();
	                // Process the service (simulating processing time)
	                Thread.sleep(1000); // Simulate time taken to process a service
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
	public class Main {
	    public static void main(String[] args) {
	        ServiceBuffer serviceBuffer = new ServiceBuffer(3);
	        System.out.println("ABDUL RAFAY / 2022F-BSE-197 / LAB 07 / TASK 03:\n");
            System.out.println("(*): SCENARIO: Car Showroom & Services (Cars Dealing and Service Centre - Regarding Car Maintenance & Services):");
            System.out.println("(*): NOTE: Displaying The Service Details(Start & End):");
            System.out.println("(*): OBJECTIVE: Concurrency with Multithreading Mechanisms:\n");
	        // Create producer and consumer threads
	        ProducerThread producer = new ProducerThread(serviceBuffer);
	        ConsumerThread consumer = new ConsumerThread(serviceBuffer);
	        System.out.println("(*): Services Details:");
	        // Start the threads
	        producer.start();
	        consumer.start();
	        // Wait for both threads to finish
	        try {
	            producer.join();
	            consumer.join();
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        System.out.println("\nAll operations completed!!!!");
	    }
	}
}
