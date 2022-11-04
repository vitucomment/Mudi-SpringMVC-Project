package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.User;

public class RequisicaoNovoUsuario {

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public User toUser() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setEnabled(true);
		return user;
	}
}
