package Type;

public class ProductType {
    private int id;
    private String type_name;
    private int discount;
    public ProductType(int id, String type_name, int discount){
        this.id = id;
        this.type_name = type_name;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }


}
