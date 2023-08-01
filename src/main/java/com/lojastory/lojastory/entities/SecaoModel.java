package com.lojastory.lojastory.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Secoes")
public class SecaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsecao;
    private String descricaosecao;
	private Boolean statussecao;
	
	public SecaoModel() {
		
	}
	
	public SecaoModel(Long idsecao, String descricaosecao, Boolean statussecao) {
		this.idsecao = idsecao;
		this.descricaosecao = descricaosecao;
		this.statussecao = statussecao;
	}

	public Long getIdsecao() {
		return idsecao;
	}

	public void setIdsecao(Long idsecao) {
		this.idsecao = idsecao;
	}

	public String getDescricaosecao() {
		return descricaosecao;
	}

	public void setDescricaosecao(String descricaosecao) {
		this.descricaosecao = descricaosecao;
	}

	public Boolean getStatussecao() {
		return statussecao;
	}

	public void setStatussecao(Boolean statussecao) {
		this.statussecao = statussecao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idsecao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecaoModel other = (SecaoModel) obj;
		return Objects.equals(idsecao, other.idsecao);
	}

}
