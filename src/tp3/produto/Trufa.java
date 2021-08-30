package tp3.produto;

import java.util.Date;

public class Trufa extends Chocolate{
    private String recheio;
    private boolean alcoolico;

    public Trufa(int id, int peso, String nome, String descricao, String tipo, Date dataCompra, double precoCompra,
                 double precoVenda, double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                 boolean artesanal, String recheio, boolean alcoolico) {
        super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal);
        this.recheio = recheio;
        this.alcoolico = alcoolico;

    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public boolean isAlcoolico() {
        return alcoolico;
    }

    public void setAlcoolico(boolean alcoolico) {
        this.alcoolico = alcoolico;
    }
}
