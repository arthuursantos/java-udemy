package lambda001.entities;

public class Player {
    protected String name;
    protected Integer number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstLetter() {
        return this.name.substring(0, 1).toUpperCase();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}