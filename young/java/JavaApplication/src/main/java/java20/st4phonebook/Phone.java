package java20.st4phonebook;

public class Phone {
    
    private String name;
    private String address;
    private String number;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return name + " " + address + " " + number;
    }
    
    public Phone() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Phone(String name, String address, String number) {
        super();
        this.name = name;
        this.address = address;
        this.number = number;
    }
    
}
