import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class sectionTests {

    @Test
    public void exe001() {
        File file = new File("C:\\Users\\arthu\\OneDrive\\Ambiente de Trabalho\\in.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

    @Test
    public void exe002() {
        String path = "C:\\Users\\arthu\\OneDrive\\Ambiente de Trabalho\\in.txt";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void exe003() {
        String path = "C:\\Users\\arthu\\OneDrive\\Ambiente de Trabalho\\in.txt";
        try (BufferedReader br =  new BufferedReader(new FileReader(path))) {
            String fileLine = br.readLine();
            while (fileLine != null) {
                System.out.println(fileLine);
                fileLine = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void exe004() {

        int mtLines = 3;
        int mtColumns = 3;
        int value = 0;
        int[][] matriz = new int[mtLines][mtColumns];
        for (int i = 0; i < mtLines; i++) {
            for (int j = 0; j < mtColumns; j++) {
                matriz[i][j] = value;
                value++;
            }
        }

        String path =  "C:\\Users\\arthu\\OneDrive\\Ambiente de Trabalho\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < mtLines; i++) {
                for (int j = 0; j < mtColumns; j++) {
                    bw.write(String.valueOf(matriz[i][j])+" ");
                }
                bw.newLine();
            }
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Test
    public void exe005() {
        String folderPath = "C:\\Users\\arthu\\OneDrive\\Documentos\\info cpf";
        File[] files = new File(folderPath).listFiles(File::isFile);
        for (File file : files) {
            System.out.println(file.getName());
        }
        boolean success = new File(folderPath+"\\mkdir").mkdir();
        System.out.println(success);
    }

}
