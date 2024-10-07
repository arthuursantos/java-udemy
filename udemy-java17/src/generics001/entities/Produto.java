package generics001.entities;

class Produto implements Comparable<Produto> {

    protected String nome;
    protected Double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Produto other) {
        return preco.compareTo(other.getPreco());
    }
}
