package NotaFiscal;

import br.fiap.cliente.Cliente;
import br.fiap.item.ItemProduto;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    private List<ItemProduto>lista;
    private Cliente cliente;
    private boolean status;

    public NotaFiscal(Cliente cliente){
        this.lista = new ArrayList<>();
        this.cliente = cliente;
        this.status = true;
    }

    public void adicionarItem(ItemProduto item){
        lista.add(item);
    }

    public double calcularTotal(){
        double total = 0;
        for(ItemProduto item : lista) {
            total+= item.calcularTotal();

        }
        return total;
    }

}
