package com.wb.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class CadastrosInicial extends Execucao{
	private Empresa empresa;

	public CadastrosInicial(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar(){
		for(int i = 1; i <= 20; i++) {
			this.empresa.getProdutos().add(new Produto("Produto " + i, (i+0.25)*3));
			this.empresa.getServicos().add(new Servico("Serviço " + i, (i+0.5)*2));
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i = 1; i <= 30; i++) {
			String genero = "";
			if(i % 2 == 0) {
				genero = "Feminino";
			} else {
				genero = "Masculino";
			}
			if (i < 10) {
				Cliente cliente = new Cliente("Richard Rafael Sacramento Soares " + i, "Richard " + i, 
						new CPF(LocalDate.parse("03/0" + i + "/200" + i, formato), "451541758/7" + i), genero);
				cliente.getRgs().add(new RG(LocalDate.parse("03/0" + i + "/200" + i, formato), i + "1.954.858-98"));
				cliente.getTelefones().add(new Telefone ("12", "99445-579" + i));
				cliente.getTelefones().add(new Telefone ("11", "99782-541" + i));
				for (int j = 0; j < i; j++) {
					if (i % 2 == 0) {
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i));
					} else {
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i));	
					}
				}
				this.empresa.getClientes().add(cliente);
			} else {
				Cliente cliente = new Cliente("Roger Fernado " + i, "Roger" + i, 
						new CPF(LocalDate.parse(i + "/06/20" + i, formato), "451541758/" + i), genero);
				cliente.getRgs().add(new RG(LocalDate.parse(i + "/06/2022", formato), i + "2.954.858-98"));
				cliente.getTelefones().add(new Telefone ("12", "99445-579" + i));
				if (i == 30) {
					cliente.getRgs().add(new RG(LocalDate.parse(i + "/06/2022", formato), i + "2.999.858-98"));
					cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-15));
					cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-13));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-15));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-13));
					cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-12));
				} else {
					if (i % 2 == 0) {
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));	
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));	
					} else {
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));	
						cliente.getProdutosConsumidos().add(this.empresa.getProdutos().get(i-10));
						cliente.getServicosConsumidos().add(this.empresa.getServicos().get(i-10));
					}
				}
				this.empresa.getClientes().add(cliente);
			}	
		}
	}
}