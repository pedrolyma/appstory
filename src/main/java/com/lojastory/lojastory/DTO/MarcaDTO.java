package com.lojastory.lojastory.DTO;

import org.springframework.data.domain.Page;

import com.lojastory.lojastory.entities.MarcaModel;

public class MarcaDTO {

	private Long Idmarca;
	private String Descricaomarca;
	private Boolean Statusmarca;
	private String Fotomarca;
	private String Mercadoriamarca;
	
	public MarcaDTO(MarcaModel marca) {
		this.Idmarca = marca.getIdmarca();
		this.Descricaomarca = marca.getDescricaomarca();
		this.Statusmarca = marca.getStatusmarca();
		this.Fotomarca = marca.getFotomarca();
		this.Mercadoriamarca = marca.getMercadoriamarca();
	}
	
	public Long getIdmarca() {
		return Idmarca;
	}

	public void setIdmarca(Long idmarca) {
		Idmarca = idmarca;
	}

	public String getDescricaomarca() {
		return Descricaomarca;
	}

	public void setDescricaomarca(String descricaomarca) {
		Descricaomarca = descricaomarca;
	}

	public Boolean getStatusmarca() {
		return Statusmarca;
	}

	public void setStatusmarca(Boolean statusmarca) {
		Statusmarca = statusmarca;
	}

	public String getFotomarca() {
		return Fotomarca;
	}

	public void setFotomarca(String fotomarca) {
		Fotomarca = fotomarca;
	}

	public String getMercadoriamarca() {
		return Mercadoriamarca;
	}

	public void setMercadoriamarca(String mercadoriamarca) {
		Mercadoriamarca = mercadoriamarca;
	}

	public static Page<MarcaDTO> converter(Page<MarcaModel> marcaModel) {
		return marcaModel.map(MarcaDTO::new);
	}
}
