package map003;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        String text = "Estou tentando fazer uma frase sem acento tentando fazer fazer sem teste vai corinthians";
        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.strip().split(" ");

        int maiorOcorrencia = 0;
        String maiorOcorrenciaKey="";

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
                if (map.get(word) > maiorOcorrencia) {
                    maiorOcorrencia = map.get(word);
                    maiorOcorrenciaKey = word;
                }
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key+": "+map.get(key));
        }

        System.out.printf("\n[MAIOR OCORRÊNCIA] %s: %d", maiorOcorrenciaKey, maiorOcorrencia);

    }
}
