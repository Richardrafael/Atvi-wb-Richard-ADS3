package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.listagemcons.ListagemProdCons;
import com.wb.listagemcons.ListarProdutosConsumidos;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class RemoverProduto extends Exclusao{
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemoverProduto(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void excluir() {
		System.out.println("\nIn�cio da remo��o de produtos consumidos por um cliente");
		System.out.println("-------------------------------------------------------");
		
		Listagem listagemClientes = new ListarTodosClientes(clientes, 0);
		listagemClientes.listar();
		
		while(true) {
			int numCliente = 0;
			while (true) {
				System.out.println("Por favor informe o numero do cliente (Digite 0 para sair):");
				numCliente = entrada.receberNumeroInteiro();
				if(numCliente == 0) {
					break;
				}
				if (numCliente > 0 && numCliente <= clientes.size()) {
					if (clientes.get(numCliente-1).getProdutosConsumidos().size() > 0) {
						break;
					} else {
						System.out.println("Este cliente n�o possui produtos consumidos!");
					}
				} else {
					System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");	
				} 	
			}
			if(numCliente == 0) {
				break;
			}
			
			Cliente cliente = clientes.get(numCliente - 1);
			
			ListagemProdCons listarProdutosConsumidos = new ListarProdutosConsumidos(cliente, 1);
			List<Produto> produtos = listarProdutosConsumidos.listarProdConsumido();
			
			int numProduto = 0; 
			int quantidade = 0;
			while (true) {
				System.out.println("Por favor informe o n�mero do produto que deseja remover:");
				numProduto = entrada.receberNumeroInteiro();
				if (numProduto > 0 && numProduto <= produtos.size()) {
					break;
				}
				System.out.println("N�mero de produto inv�lido! Verifique se est� inserindo o n�mero corretamente.");
			}
			while (true) {
				System.out.println("Por favor informe a quantidade que deseja remover (caso insira um n�mero maior que a quantidae atual, ser� exclu�do todos consumido daquele produto):");
				quantidade = entrada.receberNumeroInteiro();
				if (quantidade > 0) {
					break;
				}
				System.out.println("N�meros negativos e nulo s�o inv�lidos!");
			}
			Produto produto = produtos.get(numProduto - 1);
			for (int i = 0; i < quantidade; i++) {
				if (!cliente.getProdutosConsumidos().contains(produto)) {
					System.out.println("N�mero maior do que a quantidade que ele possui! Foram removidos todos!");
					break;
				}
				cliente.getProdutosConsumidos().remove(produto);
			}
			System.out.println("Produto consumido removido com sucesso!");
			break;
		}
	}
}