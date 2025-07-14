public class Kt {
    public static void main(String[] args){
        Product p1 = new Product("Lap", 10, 0.2);
        p1.xuatThongTin();
        System.out.println(p1.getTaxP());
        Product p2 = new Product("Dien_thoai", 5, 0.2);
        p2.xuatThongTin();
    }
}
