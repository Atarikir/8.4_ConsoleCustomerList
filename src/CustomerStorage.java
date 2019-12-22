import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
//        String email = String.valueOf(components[3].matches("(.+@.+\\..+)"));
//        String number = String.valueOf(components[2].matches("\\+7\\d{10}"));
        if (components[3].matches("\\+7\\d{10}") & components[2].matches("(.+@.+\\..+)")) {
            storage.put(name, new Customer(name, components[3], components[2]));
        }else System.out.println("invalid number or e-mail format");
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