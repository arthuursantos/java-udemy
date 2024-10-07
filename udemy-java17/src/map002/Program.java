package map002;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        String path = System.getenv("HOMEPATH")+"\\Ambiente de Trabalho\\in.txt";
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.strip().split(",");
                if (!map.containsKey(fields[0])) {
                    map.put(fields[0], Integer.parseInt(fields[1]));
                } else {
                    map.put(fields[0], map.get(fields[0]) + Integer.parseInt(fields[1]));
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

    }
}
