package entities;

public final class PessoaJuridica extends Pessoa {

    private int nFuncionario;

    public PessoaJuridica(String nome, double rendaAnual, int nFuncionario) {
        super(nome, rendaAnual);
        this.nFuncionario = nFuncionario;
    }

    public int getnFuncionario() {
        return nFuncionario;
    }

    public void setnFuncionario(int nFuncionario) {
        this.nFuncionario = nFuncionario;
    }

    @Override
    public double calcImposto() {
        double totalImposto;
        if (this.nFuncionario>10) {
            totalImposto = super.getRendaAnual()*0.14;
        } else {
            totalImposto = super.getRendaAnual()*0.16;
        }
        return totalImposto;
    }

}
