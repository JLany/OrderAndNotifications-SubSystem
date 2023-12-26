package ordersmanagement.controllers;
import ordersmanagement.models.Address;
public class CustomerController {


    public void Register() {
        String name;
        String balance;
        Address address = new Address();
        System.out.println("enter name");
        name = System.console().readLine();
        System.out.println("enter balance");
        balance = System.console().readLine();
        System.out.println("enter city");
        address.setCity(System.console().readLine());
        System.out.println("enter district");
        address.setDistrict(System.console().readLine());
        System.out.println("enter street");
        address.setStreet(System.console().readLine());
    }

}
