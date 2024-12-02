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
