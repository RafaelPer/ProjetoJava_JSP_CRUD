package net.com.callTrabalhoJava.model;

import java.util.Date;

public class Protocolo {

	protected Integer codigo;
	
	protected String problema;
	
	protected String resolucao;
	
	protected Date dataAbertura;
	
	protected Date dataFechamento;
	
	public Protocolo() {
		super();
		this.codigo = 0;
		this.problema = "";
		this.resolucao = "";
		this.dataAbertura = new Date();
		this.dataFechamento = new Date();
	}

	public Protocolo(Integer codigo, String problema, String resolucao, Date dataAbertura, Date dataFechamento) {
		super();
		this.codigo = codigo;
		this.problema = problema;
		this.resolucao = resolucao;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}
	
	public Protocolo(String problema, String resolucao, Date dataAbertura, Date dataFechamento) {
		super();
		this.problema = problema;
		this.resolucao = resolucao;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}
	
    public Protocolo(int codigo) {
        this.codigo = codigo;
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
}
