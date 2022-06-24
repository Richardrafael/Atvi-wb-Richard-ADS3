package com.wb.app;

import com.wb.io.Entrada;
import com.wb.listagem.Listagem;
import com.wb.listagem.ListarClienteGenero;
import com.wb.listagem.ListarDezConsumiram;
import com.wb.listagem.ListarMaisConsumidoGenero;
import com.wb.listagem.ListarMaisConsumidos;
import com.wb.listagem.ListarMaisConsumiramValor;
import com.wb.modelo.Empresa;

public class AppFuncionalidade extends Execucao {
	private Empresa empresa;
	private Entrada entrada;

	public AppFuncionalidade (Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de opera��o de listagem voc� deseja fazer:");
			System.out.println("1 - Todos clientes por g�nero");
			System.out.println("2 - Sevi�os ou produtos mais consumidos (em geral)");
			System.out.println("3 - Servi�os ou produtos mais consumidos por g�nero");
			System.out.println("4 - 10 clientes que mais consumiram servi�os ou produtos em quantidade");
			System.out.println("5 - 10 clientes que menos consumiram servi�os ou produtos em quantidade");
			System.out.println("6 - 5 clientes que mais gastaram em servi�os ou produtos");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			int operacaoFinal = operacao;
			if (operacao == -1) {
				operacaoFinal = -2;
			}
			if (empresa.getClientes().size() == 0 && (operacao == 1 || operacao == 4 || operacao == 5 || operacao == 6)) {
				System.out.println("N�o h� clientes cadastrados!");
				operacaoFinal = -1;
			}
			if (empresa.getProdutos().size() == 0 && empresa.getServicos().size() == 0 && (operacao == 2 || operacao == 3)) {
				System.out.println("N�o h� produtos e servi�os cadastrados!");
				operacaoFinal = -1;
			}
			switch(operacaoFinal) {
			case -1:
				break;
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Listagem listarClienteG�nero = new ListarClienteGenero(empresa.getClientes());
				listarClienteG�nero.listar();
				break;
			case 2:
				Listagem listarMaisConsumidos = new ListarMaisConsumidos(empresa);
				listarMaisConsumidos.listar();
				break;
			case 3:
				Listagem listarMaisConsumidoGenero = new ListarMaisConsumidoGenero(empresa);
				listarMaisConsumidoGenero.listar();
				break;
			case 4:
				Listagem listarDezMaisConsumiram = new ListarDezConsumiram(empresa, "mais");
				listarDezMaisConsumiram.listar();
				break;
			case 5:
				Listagem listarDezMenosConsumiram = new ListarDezConsumiram(empresa, "menos");
				listarDezMenosConsumiram.listar();
				break;
			case 6:
				Listagem listarMaisConsumiramValor = new ListarMaisConsumiramValor(empresa);
				listarMaisConsumiramValor.listar();
				break;
			default:
				System.out.println("Opera��o n�o entendida");
			}
		}
	}
}