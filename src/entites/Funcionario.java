package entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.niveis.NivelTrabalho;

public class Funcionario {

	private String nome;
	private NivelTrabalho nivel;
	private double baseSalario;
	private List<ContratoHoras> contratos = new ArrayList<ContratoHoras>();
	
	
	public Funcionario(String nome, NivelTrabalho nivel, double baseSalario) {
		
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelTrabalho getNivel() {
		return nivel;
	}


	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}


	public double getBaseSalario() {
		return baseSalario;
	}


	public void setBaseSalario(double baseSalario) {
		this.baseSalario = baseSalario;
	}
	
	
	
	
	
	public void addContract(ContratoHoras contratos) {
		this.contratos.add(contratos);
	}
	
	public void removeContract(ContratoHoras contratos) {
		this.contratos.remove(contratos);
	}
	
	
	
	public double income(int year, int month) {
		double sum = baseSalario;
		Calendar cal = Calendar.getInstance();
		for (ContratoHoras c : contratos) {
			cal.setTime(c.getData());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
	
	
}
