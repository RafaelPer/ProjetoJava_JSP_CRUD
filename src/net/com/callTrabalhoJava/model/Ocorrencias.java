package net.com.callTrabalhoJava.model;

import java.util.Date;

public class Ocorrencias {

	protected Integer codigo;

	protected Date data;

	protected String nomeUsuario;

	protected String descricao;

	protected String motivo;
	
	public Ocorrencias() {
		super();
		this.codigo = 0;
		this.data = new Date();
		this.nomeUsuario = "";
		this.descricao = "";
		this.motivo = "";
	}

	public Ocorrencias(Integer codigo, Date data, String nomeUsuario, String descricao, String motivo) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.nomeUsuario = nomeUsuario;
		this.descricao = descricao;
		this.motivo = motivo;
	}
	
	public Ocorrencias(Date data, String nomeUsuario, String descricao, String motivo) {
		super();
		this.data = data;
		this.nomeUsuario = nomeUsuario;
		this.descricao = descricao;
		this.motivo = motivo;
	}
	
    public Ocorrencias(int codigo) {
        this.codigo = codigo;
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
