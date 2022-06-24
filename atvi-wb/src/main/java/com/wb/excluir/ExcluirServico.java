package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarTodosServicos;
import com.wb.modelo.Servico;

public class ExcluirServico extends Exclusao {
	private List<Servico> servicos;
	private Entrada entrada;

	public ExcluirServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nIn�cio da exclus�o de um servi�o");
		System.out.println("--------------------------------");
				
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
		
		this.servicos.remove(numServico - 1);
		System.out.println("Servi�o exclu�do com sucesso!");
	}
}