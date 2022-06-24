package com.wb.listagem;

import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ListarClienteGenero extends Listagem {
	private List<Cliente> clientes;
	private Entrada entrada;

	public ListarClienteGenero(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Por qual g�nero voc� deseja listar?");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
					System.out.println("Opera��o n�o entendida.");
				}
			}
		}
		List<Cliente> clientesGenero = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.genero.equals(genero)) {
				clientesGenero.add(cliente);
			}
		}
		if (clientesGenero.size() == 0) {
			System.out.println("N�o h� clientes do g�nero " + genero.toLowerCase() + " cadastrados!");
		} else {
			if (genero.equals("Masculino")){
				Listagem listagemClientes = new ListarTodosClientes(clientesGenero, 2);
				listagemClientes.listar();	
			} else {
				Listagem listagemClientes = new ListarTodosClientes(clientesGenero, 3);
				listagemClientes.listar();	
			}
		}
	}	
}	