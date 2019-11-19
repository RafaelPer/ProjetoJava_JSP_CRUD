package net.com.callTrabalhoJava.model;

public class Configuracao {

	protected Integer codigo;
	
	protected String mensagem1;
	
	protected String mensagem2;
	
	protected String mensagem3;
	
	protected String mensagem4;
	
	public Configuracao() {
		super();
		this.codigo = 0;
		this.mensagem1 = "";
		this.mensagem2 = "";
		this.mensagem3 = "";
		this.mensagem4 = "";
	}

	public Configuracao(Integer codigo, String mensagem1, String mensagem2, String mensagem3, String mensagem4) {
		super();
		this.codigo = codigo;
		this.mensagem1 = mensagem1;
		this.mensagem2 = mensagem2;
		this.mensagem3 = mensagem3;
		this.mensagem4 = mensagem4;
	}
	
	public Configuracao(String mensagem1, String mensagem2, String mensagem3, String mensagem4) {
		super();
		this.mensagem1 = mensagem1;
		this.mensagem2 = mensagem2;
		this.mensagem3 = mensagem3;
		this.mensagem4 = mensagem4;
	}
	
    public Configuracao(int codigo) {
        this.codigo = codigo;
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem1() {
		return mensagem1;
	}

	public void setMensagem1(String mensagem1) {
		this.mensagem1 = mensagem1;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public void setMensagem2(String mensagem2) {
		this.mensagem2 = mensagem2;
	}

	public String getMensagem3() {
		return mensagem3;
	}

	public void setMensagem3(String mensagem3) {
		this.mensagem3 = mensagem3;
	}

	public String getMensagem4() {
		return mensagem4;
	}

	public void setMensagem4(String mensagem4) {
		this.mensagem4 = mensagem4;
	}
}
