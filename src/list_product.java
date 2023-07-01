import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class list_product {
    private int Number;
    ArrayList<Product> lst =  new ArrayList<>();
    public void add_list(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so luong san pham: ");
        Number = sc.nextInt();
        for (int i = 0; i < Number; i++) {
            Product pr = new Product();
            pr.Add();
            lst.add(pr);
        }
    }
    public void display_list(){
        for (Product x: lst) {
            x.display();
        }
    }
    public void writefile() throws RuntimeException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("products.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lst);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Luu danh sach san pham thanh cong!");
    }
    public void readfile(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("products.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst = (ArrayList<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Doc danh sach san pham thanh cong!");
    }
    public void Creatorder () {
        Scanner sc = new Scanner(System.in);
        Product pr = new Product();
        for (Product x:lst) {

            System.out.println("ma ban dau: "+x.getProductCode());
            while (true) {
                System.out.print("nhap ma san pham: ");
                String idfound = sc.nextLine();
                System.out.println(idfound);
                if (pr.getProductCode().trim().equalsIgnoreCase(idfound.trim())) {
                    System.out.println("Da nhap dung!!");
                    System.out.print("Nhap so luong mua: ");
                    int Numberbuy = sc.nextInt();
                    if(Numberbuy <=0){
                        System.out.println("nhap sai so luong: ");
                        continue;
                    }
                    String ordername = pr.getProductName();
                    Double amount = Numberbuy * pr.getPriceRetail();
                    writeorder();
                }else
                    System.out.println("Sai ma san pham, Nhap lai!!");
                continue;// if
            }
        }


    }
    public void writeorder(){
        Product product = new Product();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("orders.txt", true);
            fileWriter.write(product.getProductCode() + " | " + product.getProductName() + " | " + product.getImportPrice() + " | " + product.getPriceRetail() + " | " + product.getQuantityInStock()+ "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}// class
