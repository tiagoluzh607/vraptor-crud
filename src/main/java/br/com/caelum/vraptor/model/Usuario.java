package br.com.caelum.vraptor.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Usuario extends Model {

	@Email @NotEmpty
	private String email;
	
	@NotEmpty @Size(min=3, max=12)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public String getDataNascimentoFormatada() {
		return formatCalendar(this.dataNascimento);
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
}
