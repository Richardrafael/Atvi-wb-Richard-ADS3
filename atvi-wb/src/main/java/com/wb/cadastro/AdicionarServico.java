package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosClientes;
import com.wb.listagem.ListarTodosServicos;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class AdicionarServico extends Cadastro {
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private Entrada entrada;

	public AdicionarServico(List<Cliente> clientes, List<Servico> servicos) {
		this.clientes = clientes;
		this.servicos = servicos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("\nIn�cio da adi��o de servi�os consumidos por um cliente");
		System.out.println("------------------------------------------------------");
		
		Listagem listagemClientes = new ListarTodosClientes(clientes, 2);
		listagemClientes.listar();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		Listagem listarServicos = new ListarTodosServicos(servicos);
		listarServicos.listar();
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do servi�o que deseja adicionar:");
			numServico = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Servico servico = servicos.get(numServico - 1);
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getServicosConsumidos().add(servico);
		}
		System.out.println("Servi�o consumido adicionado com sucesso!");
	}
}