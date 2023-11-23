package com.mvc.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Builder
	
	public class AddressRequest {
		@Id
		private Integer id;
		@NotNull(message = "Adresse must not be null")
		private String homeAddress;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getHomeAddress() {
			return homeAddress;
		}
		public void setHomeAddress(String homeAddress) {
			this.homeAddress = homeAddress;
		}
		

}

