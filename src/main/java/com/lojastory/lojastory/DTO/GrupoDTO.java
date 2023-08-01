package com.lojastory.lojastory.DTO;

import org.springframework.data.domain.Page;

import com.lojastory.lojastory.entities.GrupoModel;

public class GrupoDTO {

	private Long idgrupo;
	private String Descricaogrupo;
	private Boolean Statusgrupo;
	
	public GrupoDTO(GrupoModel grupoModel) {
		this.idgrupo = grupoModel.getIdgrupo();
		this.Descricaogrupo = grupoModel.getDescricaogrupo();
		this.Statusgrupo = grupoModel.getStatusgrupo();
	}

	public Long getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getDescricaogrupo() {
		return Descricaogrupo;
	}

	public void setDescricaogrupo(String descricaogrupo) {
		Descricaogrupo = descricaogrupo;
	}

	public Boolean getStatusgrupo() {
		return Statusgrupo;
	}

	public void setStatusgrupo(Boolean statusgrupo) {
		Statusgrupo = statusgrupo;
	}
	
	public static Page<GrupoDTO> converter(Page<GrupoModel> grupoModel) {
		return grupoModel.map(GrupoDTO::new);
	}
}
