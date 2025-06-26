public class Product {
    private String name;
    private double price;
    private double tax;

    public Product(String name, double price, double tax){
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public double getTax(){
        return this.tax;
    }

    public void setTax(Double tax){
        this.tax = tax;
    }

    public void nhapThongtin(String name, double price, double tax){
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public void xuatThongTin(){
        System.out.println(this.name);
        System.out.println(this.price);
        System.out.println(this.tax);
    }

    public double getTaxP(){
        return this.price * this.tax;
    }
}
