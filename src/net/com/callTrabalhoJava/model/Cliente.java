package net.com.callTrabalhoJava.model;

public class Cliente {

	protected Integer codigo;

	protected String razao;

	protected String fantasia;

	protected String cnpj;

	protected String ie;

	public Cliente() {
		super();
		this.codigo = 0;
		this.razao = "";
		this.fantasia = "";
		this.cnpj = "";
		this.ie = "";
	}

	public Cliente(Integer codigo, String razao, String fantasia, String cnpj, String ie) {
		super();
		this.codigo = codigo;
		this.razao = razao;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.ie = ie;
	}
	
	public Cliente(String razao, String fantasia, String cnpj, String ie) {
		super();
		this.razao = razao;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.ie = ie;
	}
	
    public Cliente(int codigo) {
        this.codigo = codigo;
    }
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}
}