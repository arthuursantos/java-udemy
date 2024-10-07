package map001;

import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        //estrutura chave-valor
        //nao permite repeticoes de chave, novas entradas vao substituir as existentes

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Arthur");
        cookies.put("email", "arthur@yahoo.com");
        cookies.put("phone", "19999356789");

        cookies.remove("phone");
        System.out.println("cookies.containsKey "+cookies.containsKey("phone"));
        System.out.println("cookies.get "+cookies.get("email"));
        System.out.println("cookies.size "+cookies.size());

        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

    }
}
