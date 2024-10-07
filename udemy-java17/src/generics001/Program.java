package generics001;

import generics001.services.Services;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Services<Integer> psStrings = new Services<>();

        System.out.print("How many values: "); int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("VALUE %d: ", i+1);
            Integer value = sc.nextInt();
            psStrings.addValue(value);
        }

        psStrings.print();
        System.out.println("\nFIRST VALUE: " + psStrings.first());

//        String path = System.getenv("HOMEPATH")+"\\Ambiente de Trabalho\\in.txt";
//        List<generics001.entities.Produto> listProdutos = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            String line = br.readLine();
//            while (line != null) {
//                String[] fields = line.split(",");
//                listProdutos.add(new generics001.entities.Produto(fields[0], Double.parseDouble(fields[1])));
//                line = br.readLine();
//                System.out.println(fields[1]);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        generics001.entities.Produto max = generics001.services.services.max(listProdutos);
//        System.out.println("Most expensive: " + max);

    }
}
