package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = System.getenv("HOMEPATH")+"\\Ambiente de Trabalho\\exeFiles\\in.txt";
        File file = new File(path);

        List<Product> listProducts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String fileLine = br.readLine();
            while (fileLine != null) {
                String[] productInfo = fileLine.split(",");
                listProducts.add(new Product(productInfo[0], Double.parseDouble(productInfo[1]), Integer.parseInt(productInfo[2])));
                fileLine = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("deu bolete: " + e.getMessage());
        }

        new File(file.getParent()+"\\out").mkdir();
        try (BufferedWriter bw =  new BufferedWriter(new FileWriter(file.getParent()+"\\out\\summary.csv"))) {
            for (Product product : listProducts) {
                bw.write(product.getName() + "," + product.total());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("deu bolete: " + e.getMessage());
        }
    }
}
