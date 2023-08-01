package com.lojastory.lojastory.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Fornecedor")
public class FornecedorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idfornecedor;
	private String razaosocial;
	private String nomefantasia;
	private String cnpj;
	private String inscricao;
	private String telefone;
	private String whatsapp;
	private String emailfor;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String contato;
	private String precobom;
	private String site;
	private String nomebanco;
	private String agencia;
	private String conta;
	private String pix;
	private String obs;
	
	public FornecedorModel(Long idfornecedor, String razaosocial, String nomefantasia, String cnpj, String inscricao,
			String telefone, String whatsapp, String emailfor, String cep, String logradouro, String numero, String bairro, String cidade,
			String estado, String contato, String precobom, String site, String nomebanco, String agencia, String conta,
			String pix, String obs) {
		Idfornecedor = idfornecedor;
		this.razaosocial = razaosocial;
		this.nomefantasia = nomefantasia;
		this.cnpj = cnpj;
		this.inscricao = inscricao;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.emailfor = emailfor;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.contato = contato;
		this.precobom = precobom;
		this.site = site;
		this.nomebanco = nomebanco;
		this.agencia = agencia;
		this.conta = conta;
		this.pix = pix;
		this.obs = obs;
	}

	public Long getIdfornecedor() {
		return Idfornecedor;
	}

	public void setIdfornecedor(Long idfornecedor) {
		Idfornecedor = idfornecedor;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmailfor() {
		return emailfor;
	}

	public void setEmailfor(String emailfor) {
		this.emailfor = emailfor;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getPrecobom() {
		return precobom;
	}

	public void setPrecobom(String precobom) {
		this.precobom = precobom;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getNomebanco() {
		return nomebanco;
	}

	public void setNomebanco(String nomebanco) {
		this.nomebanco = nomebanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Idfornecedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorModel other = (FornecedorModel) obj;
		return Objects.equals(Idfornecedor, other.Idfornecedor);
	}
}

