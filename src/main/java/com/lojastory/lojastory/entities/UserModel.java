package com.lojastory.lojastory.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Usuario")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
    private Long idusuario;
    private String nameusuario;
    private String username;
    private String password;
    @ManyToMany
    private List<RoleModel> roles;
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNameusuario() {
		return nameusuario;
	}
	public void setNameusuario(String nameusuario) {
		this.nameusuario = nameusuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idusuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(idusuario, other.idusuario);
	}
}
