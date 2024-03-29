package com.e.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Email
	    @Column(nullable = false)
	    private String email;
	    
	    
		private String imageUrl;

	    @Column(nullable = false)
	    private Boolean emailVerified = false;

	    @JsonIgnore
	    private String password;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private AuthProvider provider;

	    private String providerId;
	    
	    @Enumerated(EnumType.STRING)
	    private Gender gender;
 
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Boolean getEmailVerified() {
			return emailVerified;
		}

		public void setEmailVerified(Boolean emailVerified) {
			this.emailVerified = emailVerified;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public AuthProvider getProvider() {
			return provider;
		}

		public void setProvider(AuthProvider provider) {
			this.provider = provider;
		}

		public String getProviderId() {
			return providerId;
		}

		public void setProviderId(String providerId) {
			this.providerId = providerId;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

	

	    @Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", imageUrl=" + imageUrl
					+ ", emailVerified=" + emailVerified + ", password=" + password + ", provider=" + provider
					+ ", providerId=" + providerId + ", gender=" + gender + "]";
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Long id, String name, @Email String email, String imageUrl, Boolean emailVerified, String password,
				@NotNull AuthProvider provider, String providerId, Gender gender) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.imageUrl = imageUrl;
			this.emailVerified = emailVerified;
			this.password = password;
			this.provider = provider;
			this.providerId = providerId;
			this.gender = gender;
		}

}
