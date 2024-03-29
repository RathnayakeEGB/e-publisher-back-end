package com.e.configaration.security.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequest {

	   @NotBlank
	    private String name;

	    @NotBlank
	    @Email
	    private String email;

	    @NotBlank
	    private String password;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public SignUpRequest(@NotBlank String name, @NotBlank @Email String email, @NotBlank String password) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
		}

		@Override
		public String toString() {
			return "SignUpRequest [name=" + name + ", email=" + email + ", password=" + password + "]";
		}

		public SignUpRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	
}
