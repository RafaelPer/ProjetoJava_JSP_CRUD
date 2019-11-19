package net.com.callTrabalhoJava.model;

import java.util.Date;

public class ContaReceber{

	protected Integer codigo;
	
	protected Date emissao;
	
	protected Date vencimento;
	
	protected Date pagamento;
	
	protected float valor;

	public ContaReceber() {
		super();
		this.codigo = 0;
		this.emissao = new Date();
		this.vencimento = new Date();
		this.pagamento = new Date();
		this.valor = 0;
	}

	public ContaReceber(Integer codigo, Date emissao, Date vencimento, Date pagamento, float valor) {
		super();
		this.codigo = codigo;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.valor = valor;
	}
	
	public ContaReceber(Date emissao, Date vencimento, Date pagamento, float valor) {
		super();
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.valor = valor;
	}
	
    public ContaReceber(int codigo) {
        this.codigo = codigo;
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
