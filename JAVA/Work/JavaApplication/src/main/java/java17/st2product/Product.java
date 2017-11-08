package java17.st2product;

public class Product {

    protected int id = 0;
    protected String explain = "";
    protected String producer = "";
    protected int price = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", explain=" + explain + ", producer=" + producer + ", price=" + price + "]";
    }

    public void PrintProduct() {

        System.out.print("------------------------\n");
        System.out.println("상품 ID :" + id);
        System.out.println("설명 :" + explain);
        System.out.println("생산자 :" + producer);
        System.out.println("가격 :" + price);
        System.out.print("------------------------\n");

    }
}
