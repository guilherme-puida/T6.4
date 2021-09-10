package tp3.produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Chocotone extends Chocolate{
    private String recheio;
    private final ArrayList<String> frutas = new ArrayList<>();

    public Chocotone(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra, double precoCompra,
                     double precoVenda, double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                     boolean artesanal, String recheio, String[] frutas) {
        super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal);

        this.recheio = recheio;
        Collections.addAll(this.frutas, frutas);
    }

    public String infoBasica() {
        return String.format("Id: %d | Nome: %s | Peso: %d | Sabor: %s | Nibs: %s | Preço: %.2f",
                super.getId(), super.getNome(), super.getPeso(), recheio, String.join(", ", frutas),
                super.getPrecoVenda());
    }

    public String infoCompleta() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                "Id:%d|Peso:%d|Nome:%s|Descrição:%s|Tipo:%s|Data de compra:%s|" +
                        "Preco da compra:$%.2f|Preco de venda:.%.2f|Porcentagem de Cacau:%.2f|" +
                        "Gluten:%s|Lactose:%s|Artesanal:%s|Recheio:%s|Frutas:%s",
                super.getId(), super.getPeso(), super.getNome(), super.getDescricao(), super.getTipo(),
                super.getDataCompra().format(dtf), super.getPrecoCompra(), super.getPrecoVenda(),
                super.getPorcentagemCacau(), super.isContemGluten(), super.isContemLactose(), super.isArtesanal(),
                recheio, String.join(", ", frutas)
        );
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getFrutas() {
        return frutas.toString();
    }

    public void addFruta(String fruta) {
        if (!frutas.contains(fruta)) {
            frutas.add(fruta);
        }
    }

    public void removeFruta(String fruta) {
        frutas.remove(fruta);
    }
}
