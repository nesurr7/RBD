package sample;

public class Order {
    private int order_id;
    private String type_name;
    private String product_name;
    private String manufacturer_name;
    private int dis_cost;
    private String delivery_date;
    private String delivery_address;

    Order( int order_id,
           String type_name,
           String product_name,
           String manufacturer_name,
           int dis_cost,
           String delivery_date,
           String delivery_address){
        this.manufacturer_name=manufacturer_name;
        this.delivery_address=delivery_address;
        this.delivery_date=delivery_date;
        this.order_id=order_id;
        this.dis_cost=dis_cost;
        this.product_name=product_name;
        this.type_name=type_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public void setDis_cost(int dis_cost) {
        this.dis_cost = dis_cost;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType_name() {
        return type_name;
    }

    public int getDis_cost() {
        return dis_cost;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public String getProduct_name() {
        return product_name;
    }
}

