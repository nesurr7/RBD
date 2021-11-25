package Product;

public class Product {

    private String name;
    private String manufacturer;
    private String material;
    private String color;
    private float volume;
    private float weight;
    private int price;
    private int id;
    public Product(String name,
                   String manufacturer,
                   String material,
                   String color,
                   float volume,
                   float weight,
                   int price,
                   int id){
        this.name=name;
        this.manufacturer=manufacturer;
        this.material=material;
        this.color=color;
        this.volume=volume;
        this.weight=weight;
        this.price=price;
        this.id=id;
    }

    public float getVolume() {
        return volume;
    }

    public float getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(int features_id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
