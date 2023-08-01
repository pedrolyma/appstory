package com.lojastory.lojastory.entityrequest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MarcaRequest {
	
	@NotNull
	@Size(max = 100)
	private String DescricaoMarca;
	private String StatusMarca;
	private String FotoMarca;
	private String MercadoriaMarca;
	
	public void setDescricaoMarca(String descricaoMarca) {
		DescricaoMarca = descricaoMarca;
	}
	public void setStatusMarca(String statusMarca) {
		StatusMarca = statusMarca;
	}
	public void setFotoMarca(String fotoMarca) {
		FotoMarca = fotoMarca;
	}
	public void setMercadoriaMarca(String mercadoriaMarca) {
		MercadoriaMarca = mercadoriaMarca;
	}

}
