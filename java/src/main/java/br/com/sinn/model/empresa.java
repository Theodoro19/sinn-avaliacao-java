package br.com.sinn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private int codigo;
	@Column(columnDefinition = "varchar(75)")
	private String nome_empresa;
	@Column(columnDefinition = "numeric(14,0)")
	private double cnpj;
	@Column(columnDefinition = "varchar(50)")
	private String dono_empresa;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<pessoa> pessoa = new ArrayList<>();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome_empresa() {
		return nome_empresa;
	}

	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}

	public double getCnpj() {
		return cnpj;
	}

	public void setCnpj(double cnpj) {
		this.cnpj = cnpj;
	}

	public String getDono_empresa() {
		return dono_empresa;
	}

	public void setDono_empresa(String dono_empresa) {
		this.dono_empresa = dono_empresa;
	}

	public List<pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cnpj);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + codigo;
		result = prime * result + ((dono_empresa == null) ? 0 : dono_empresa.hashCode());
		result = prime * result + ((nome_empresa == null) ? 0 : nome_empresa.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		empresa other = (empresa) obj;
		if (Double.doubleToLongBits(cnpj) != Double.doubleToLongBits(other.cnpj))
			return false;
		if (codigo != other.codigo)
			return false;
		if (dono_empresa == null) {
			if (other.dono_empresa != null)
				return false;
		} else if (!dono_empresa.equals(other.dono_empresa))
			return false;
		if (nome_empresa == null) {
			if (other.nome_empresa != null)
				return false;
		} else if (!nome_empresa.equals(other.nome_empresa))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}
