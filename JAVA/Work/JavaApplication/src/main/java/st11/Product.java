package st11;

public class Product {
    
    protected int id = 0;
    protected String explain = "";
    protected String producer = "";
    protected int price = 0;
    protected int type = 0;
    
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
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
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
    return "상품 ID : "+id+"\n"+"상품 설명 : "+explain+"\n"+"생산자 : "+producer+"\n"+"가격 : "+ price+"\n";
    }

}

