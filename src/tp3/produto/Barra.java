package tp3.produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Barra extends Chocolate{
    private String sabor;
    private final ArrayList<String> nibs = new ArrayList<>();

    public Barra(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra,
                 double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
                 boolean contemLactose, boolean artesanal, String sabor, String[] nibs) {
        super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal);

        this.sabor = sabor;
        Collections.addAll(this.nibs, nibs);
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getNibs() {
        return nibs.toString();
    }

    public void addNib(String nib) {
        if (!nibs.contains(nib)) {
            nibs.add(nib);
        }
    }

    public void removeNib(String nib) {
        nibs.remove(nib);
    }

    public String infoBasica() {
        return String.format("Id: %d | Nome: %s | Peso: %dg | Sabor: %s | Nibs: %s | Preço: %.2f",
                super.getId(), super.getNome(), super.getPeso(), sabor, String.join(", ", nibs),
                super.getPrecoVenda());
    }
}
