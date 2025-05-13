package br.fiap.controle;
import NotaFiscal.NotaFiscal;
import br.fiap.cliente.Cliente;
import br.fiap.produto.Produto;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Produto> listaProduto = new ArrayList<>();
    private static List<Cliente> listaCliente = new ArrayList<>();
    private NotaFiscal nf;

    static{
        listaCliente.add(new Cliente(123,"ana maria"));
        listaCliente.add(new Cliente(456,"Roberto Carlos"));
        listaCliente.add(new Cliente(789,"Xuxa da Silva"));

        listaProduto.add(new Produto(1, "camiseta", 390, 100));
        listaProduto.add(new Produto(2, "calça", 2000, 500));
        listaProduto.add(new Produto(3, "tenis", 5000, 100));

    }

    public Controle(){
        Cliente cliente = pesquisar();
        nf = new NotaFiscal(cliente);
    }

    public void menu() {
        int opcao;
        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
            }
            catch (NumberFormatException e){
                showInputDialog(null, "A opção deve ser um número");
            }
        }
    }

    private Cliente pesquisar(){
        long cpf = parseLong(showInputDialog("CPF do cliente"));
        for(Cliente cliente : listaCliente){
            if(cliente.getCpf() == cpf){
                return cliente;
            }
        }
        return null;
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE COMPRAS ONLINE\n";
        aux += "1. Adicionar produto\n";
        aux += "2. Remover produto\n";
        aux += "3. Fechar compra\n";
        aux += "4. Finalizar compra\n";
        return aux;
    }

}
