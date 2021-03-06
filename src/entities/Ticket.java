package entities;

import java.io.Serializable;

public class Ticket implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String client;
	private String cnpj;
	private String endereco;
	
	
	public Ticket() {
		
	}


	public Ticket(Integer id, String name, String client, String cnpj, String endereco) {
		super();
		this.id = id;
		this.name = name;
		this.client = client;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", client=" + client + ", cnpj=" + cnpj + ", endereco="
				+ endereco + "]";
	}
	
	


}
