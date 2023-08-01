package com.lojastory.lojastory.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Agenda")
public class AgendaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idagenda;
	private LocalDate datacadastro;
	private String nomeagenda;
	private String emailagenda;
	private String whatsappagenda;
	private String observacao;
	
	public AgendaModel() {
		
	}
	public long getIdagenda() {
		return idagenda;
	}
	public void setIdagenda(long idagenda) {
		this.idagenda = idagenda;
	}
	public LocalDate getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}
	public String getNomeagenda() {
		return nomeagenda;
	}
	public void setNomeagenda(String nomeagenda) {
		this.nomeagenda = nomeagenda;
	}
	public String getEmailagenda() {
		return emailagenda;
	}
	public void setEmailagenda(String emailagenda) {
		this.emailagenda = emailagenda;
	}
	public String getWhatsappagenda() {
		return whatsappagenda;
	}
	public void setWhatsappagenda(String whatsappagenda) {
		this.whatsappagenda = whatsappagenda;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public AgendaModel(long idagenda, LocalDate datacadastro, String nomeagenda, String emailagenda,
			String whatsappagenda, String observacao) {
		super();
		this.idagenda = idagenda;
		this.datacadastro = datacadastro;
		this.nomeagenda = nomeagenda;
		this.emailagenda = emailagenda;
		this.whatsappagenda = whatsappagenda;
		this.observacao = observacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idagenda);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaModel other = (AgendaModel) obj;
		return idagenda == other.idagenda;
	}


}
