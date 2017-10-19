package dto;

import javax.persistence.Column;

public class DoadorDTO {

	private String nome;
	private Character localizacao;

	
	@Column(name = "nomedoador")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Character localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "DoadorDTO [nome=" + nome + ", localizacao=" + localizacao + "]";
	}

}
