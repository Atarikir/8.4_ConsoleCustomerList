import Exceptions.*;

import java.util.HashMap;

public class CustomerStorage {
    private static String commandError = "Wrong command! Available command examples: add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws RuntimeException {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        if (!components[2].matches("(.+@.+\\..+)")) {
            throw new NotValidEmailException(commandError);
        } else if (!components[3].matches("\\+7\\d{10}")) {
            throw new NotValidPhoneException(commandError);
        } else storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}