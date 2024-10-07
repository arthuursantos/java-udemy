package lambda001;

import lambda001.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        //funcoes anonimas (arrow functions/lambdas) enxugam o codigo
        //nao ha necessidade de declarar metodos por completo
        //uteis em processos de colecoes (ordenacoes, filter, map, reduce, etc)
        //em ordenacoes, inverter os argumentos no corpo da funcao ordena de maneira decrescente

        List<Player> listPlayers = new ArrayList<Player>();

        listPlayers.add(new Player("Memphis", 94));
        listPlayers.add(new Player("Garro", 10));
        listPlayers.add(new Player("Hugo Souza", 22));
        listPlayers.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Player player : listPlayers) {
            System.out.println(player);
        }

    }
}
