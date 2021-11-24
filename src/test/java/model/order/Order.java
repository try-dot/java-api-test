package model.order;

import com.github.javafaker.Faker;

public class Order {

    private Integer id;
    private Integer petId;
    private Integer quantity;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private String shipDate;
    private Status status;
    private Boolean complete;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public static Order generateRandomOrder(Status status) {

        int minId = 1;
        int maxId = 10;
        final Order order = new Order();
        Faker faker = new Faker();
        order.setId(faker.number().numberBetween(minId, maxId));
        order.setPetId(faker.number().numberBetween(minId, maxId));
        order.setQuantity(faker.number().randomDigit());
        order.setShipDate(faker.date().birthday().toString());
        order.setShipDate(faker.date().birthday().toString());
        order.setStatus(status);
        order.setComplete(faker.bool().bool());
        return order;

    }

}
