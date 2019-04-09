package westminster.sanduni.kitchenmanager.Model;

/**
 * Created by Sanduni Chamika
 * w1673755
 * 2017541
 * on 3/20/19
 */
public class Product {

    private String prod_name;
    private double weight;
    private double price;
    private String description;
    private int availability;

    public Product() {
    }

    public Product(String prod_name, double weight, double price, String description, int availability) {
        this.prod_name = prod_name;
        this.weight = weight;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    public Product(String description) {
        this.description = description;
    }

    public String getProd_name() {
        return prod_name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int isAvailability() {
        return availability;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
