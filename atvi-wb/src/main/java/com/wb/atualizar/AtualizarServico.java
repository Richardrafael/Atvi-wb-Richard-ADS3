package com.wb.atualizar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosServicos;
import com.wb.modelo.Servico;

public class AtualizarServico extends Atualizacao{
	private List<Servico> servicos;
	private Entrada entrada;

	public AtualizarServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("\nIn�cio da atualiza��o de um servi�o");
		System.out.println("-----------------------------------");

		Listagem listarServicos = new ListarTodosServicos(servicos);
		listarServicos.listar();
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do servi�o que deseja atualizar:");
			numServico = entrada.receberNumeroInteiro();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Servico servico = servicos.get(numServico - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			
			System.out.println("\nInforma��es do servi�o:");
			System.out.println("1) Nome: " + servico.nome);
			System.out.println("2) Valor: " + servico.valor);
			System.out.println("0) Sair");
	
			System.out.println("Por favor informe o numero do dado que voc� deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
			case 1:
				System.out.println("Por favor informe o novo valor do nome (Atual: " + servico.nome + "):");
				String nome = entrada.receberTexto();
				servico.nome = nome;
				System.out.println("Nome do servi�o atualizado com sucesso!");
				break;
			case 2:
				System.out.println("Por favor informe o novo valor (Atual: " + servico.valor + "):");
				double valor = entrada.receberNumeroDouble();
				servico.valor = valor;
				System.out.println("Valor do servi�o atualizado com sucesso!");
				break;
			default:
				System.out.println("Opera��o n�o entendida.");
			}	
		}
	}
}