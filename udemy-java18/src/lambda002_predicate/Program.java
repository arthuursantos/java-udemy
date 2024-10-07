package lambda002_predicate;

import lambda001.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        //o predicate é uma interface funcional (possui um unico metodo abstrato)
        //seu metodo é um test, retorna boolean
        //pode ser usado com removeIf, removendo um elemento se tal condicao retornar true

        List<Player> listPlayers = new ArrayList<>();

        listPlayers.add(new Player("Romero", 11));
        listPlayers.add(new Player("Garro", 10));
        listPlayers.add(new Player("Hugo Souza", 1));
        listPlayers.add(new Player("Igor Coronado", 77));
        listPlayers.add(new Player("Gustavo Henrique", 13));

        listPlayers.removeIf(player -> player.getFirstLetter().equals("G"));
        for (Player player : listPlayers) {
            System.out.println(player.getFirstLetter());
        }

    }
}
