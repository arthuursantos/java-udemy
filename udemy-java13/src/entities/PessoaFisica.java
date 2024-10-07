package entities;

public final class PessoaFisica extends Pessoa {

    private double gastosSaude;

    public PessoaFisica() {}

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcImposto() {
        double impostoTotal;
        if (super.getRendaAnual()<20000) {
            impostoTotal = super.getRendaAnual()*0.15;
        } else {
            impostoTotal = super.getRendaAnual()*0.25;
        }
        if (gastosSaude>0) {
            impostoTotal -= (gastosSaude*0.5);
        }
        return impostoTotal;
    }

}
