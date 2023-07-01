import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private double priceRetail;
    private double importPrice;
    private int quantityInStock;

    public Product(String productCode, String productName, double priceRetail, double importPrice, int quantityInStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.priceRetail = priceRetail;
        this.importPrice = importPrice;
        this.quantityInStock = quantityInStock;
    }

    public Product() {
        this.productCode = "";
        this.productName = "";
        this.priceRetail = 0;
        this.importPrice = 0;
        this.quantityInStock = 0;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(double priceRetail) {
        this.priceRetail = priceRetail;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public void Add (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        productCode = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        productName = sc.nextLine();
        System.out.print("Nhap gia ban le: ");
        priceRetail = sc.nextDouble();
        System.out.print("Nhap gia nhap hang: ");
        importPrice = sc.nextDouble();
        System.out.print("Nhap so luong san pham ton trong kho: ");
        quantityInStock = sc.nextInt();
    }
    public  void display(){
        System.out.println(productCode + "|" + productName + "|" + priceRetail + "|" + importPrice + "|" + quantityInStock);
    }
}
