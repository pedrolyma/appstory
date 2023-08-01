package com.lojastory.lojastory.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Marcas")
public class MarcaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmarca;
    private String descricaomarca;
	private Boolean statusmarca;
	private String fotomarca;
	private String mercadoriamarca;
	
	public MarcaModel() {
		
	}

	public MarcaModel(Long idMarca, String descricaoMarca, Boolean statusMarca, String fotoMarca, String mercadoriaMarca) {
		idmarca = idMarca;
		descricaomarca = descricaoMarca;
		statusmarca = statusMarca;
		fotomarca = fotoMarca;
		mercadoriamarca = mercadoriaMarca;
	}

	public Long getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Long idmarca) {
		this.idmarca = idmarca;
	}

	public String getDescricaomarca() {
		return descricaomarca;
	}

	public void setDescricaomarca(String descricaomarca) {
		this.descricaomarca = descricaomarca;
	}

	public Boolean getStatusmarca() {
		return statusmarca;
	}

	public void setStatusmarca(Boolean statusmarca) {
		this.statusmarca = statusmarca;
	}

	public String getFotomarca() {
		return fotomarca;
	}

	public void setFotomarca(String fotomarca) {
		this.fotomarca = fotomarca;
	}

	public String getMercadoriamarca() {
		return mercadoriamarca;
	}

	public void setMercadoriamarca(String mercadoriamarca) {
		this.mercadoriamarca = mercadoriamarca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idmarca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcaModel other = (MarcaModel) obj;
		return Objects.equals(idmarca, other.idmarca);
	}
}