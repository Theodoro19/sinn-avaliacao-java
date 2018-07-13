package br.com.sinn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private int codigo;
	@Column(columnDefinition = "varchar(50)")
	private String nome;
	@Column(columnDefinition = "varchar(20)")
	private String cpf;
	@Column(columnDefinition = "numeric(12,2)")
	private double salario_atual;
	@Column(columnDefinition = "numeric(12,2)")
	private double salario_reajuste;
	@ManyToOne
	private empresa empresa;
	@ManyToOne
	private cargo cargo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario_atual() {
		return salario_atual;
	}

	public void setSalario_atual(double salario_atual) {
		this.salario_atual = salario_atual;
	}

	public double getSalario_reajuste() {
		return salario_reajuste;
	}

	public void setSalario_reajuste(double salario_reajuste) {
		this.salario_reajuste = salario_reajuste;
	}

	public empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(empresa empresa) {
		this.empresa = empresa;
	}

	public cargo getCargo() {
		return cargo;
	}

	public void setCargo(cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario_atual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salario_reajuste);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pessoa other = (pessoa) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (codigo != other.codigo)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(salario_atual) != Double.doubleToLongBits(other.salario_atual))
			return false;
		if (Double.doubleToLongBits(salario_reajuste) != Double.doubleToLongBits(other.salario_reajuste))
			return false;
		return true;
	}

}
