public class Product {
    private String name;
    private double price;
    private double tax;

    public void nhapThongTin(String name, double price, double tax){
        this.name = name;
        this.price = price;
        this.tax = tax;
    }
    
    public void xuatThongTin(){
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
        System.out.println("Tax : " + tax);
        System.out.println("Tien thue: " + price * tax);
    }

    public void setter(String name){
        this.name = name;
    }
}
