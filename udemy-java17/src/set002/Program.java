package set002;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        //estruturas set testam igualdade por hashset e equals definidos em sua classe
        //caso nao tenham hashset/equals definido, sera pelos ponteiros
        //isso faz com que objetos com o mesmo conteudo se repitam dentro do set

        //um treeset, ao inves de hashset/equals, precisa que a classe implemente uma interface comparable
        //assim os elementos sao ordenados dentro da estrutura

        Set<Product> setProducts = new HashSet<>();

        setProducts.add(new Product("TV", 3899));
        setProducts.add(new Product("Notebook", 7899));
        setProducts.add(new Product("Calça Baggy", 329));

        Product pdt = new Product("Calça Baggy", 329);

        System.out.println(setProducts.contains(pdt));

    }
}
