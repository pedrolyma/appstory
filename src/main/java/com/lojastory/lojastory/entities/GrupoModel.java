package com.lojastory.lojastory.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Grupos")
public class GrupoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idgrupo;
	private String descricaogrupo;
	private Boolean statusgrupo;
	
	public GrupoModel() {
		
	}
	
	public GrupoModel(Long idgrupo, String descricaogrupo, Boolean statusgrupo) {
		this.idgrupo = idgrupo;
		this.descricaogrupo = descricaogrupo;
		this.statusgrupo = statusgrupo;
	}

	public Long getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getDescricaogrupo() {
		return descricaogrupo;
	}

	public void setDescricaogrupo(String descricaogrupo) {
		this.descricaogrupo = descricaogrupo;
	}

	public Boolean getStatusgrupo() {
		return statusgrupo;
	}

	public void setStatusgrupo(Boolean statusgrupo) {
		this.statusgrupo = statusgrupo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idgrupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoModel other = (GrupoModel) obj;
		return Objects.equals(idgrupo, other.idgrupo);
	}
	
}
