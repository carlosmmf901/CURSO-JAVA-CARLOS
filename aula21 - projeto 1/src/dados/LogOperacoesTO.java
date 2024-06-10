package dados;

import java.util.Objects;

public class LogOperacoesTO {
	public int id;
	public String operacoes;
	public String descricao;
	public String dataOperacao;
	
	public LogOperacoesTO(int id, String operacoes, String descricao, String dataOperacao) {
		super();
		this.id = id;
		this.operacoes = operacoes;
		this.descricao = descricao;
		this.dataOperacao = dataOperacao;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOperacoes() {
		return operacoes;
	}
	
	public void setOperacoes(String operacoes) {
		this.operacoes = operacoes;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDataOperacao() {
		return dataOperacao;
	}
	
	public void setDataOperacao(String dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	
	@Override
	public String toString() {
		return "LogOperacoesTO [id=" + id + ", operacoes=" + operacoes + ", descricao=" + descricao + ", dataOperacao="
				+ dataOperacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataOperacao, descricao, id, operacoes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogOperacoesTO other = (LogOperacoesTO) obj;
		return Objects.equals(dataOperacao, other.dataOperacao) && Objects.equals(descricao, other.descricao)
				&& id == other.id && Objects.equals(operacoes, other.operacoes);
	}
	
	
	
	
}
