package imooc.reflect;

public class Goods {
    private int goodNumber;
    private String name;
    private float price;
    private String description;

    public Goods() {
    }

    public Goods(int goodNumber, String name, float price, String description) {
        this.goodNumber = goodNumber;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(int goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void display(Goods goods){
        System.out.println(goods);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodNumber=" + goodNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
