package my.rajat.CoffeeGrab;


import java.io.Serializable;

/**
 * Created by Rajat on 2017-08-27.
 */

public class context_data_model implements Serializable {

    String name, description, category, delivery;
    int amount;
    int dt;

    public context_data_model(String name, String description, String category, String delivery, int amount
    , int dt){
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.dt += dt;
        this.delivery = delivery;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDt() {
        return dt;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDelivery() { return delivery; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }
}
