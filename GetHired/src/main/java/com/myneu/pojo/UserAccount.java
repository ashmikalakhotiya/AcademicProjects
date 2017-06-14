package com.myneu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="UserAccount")
@Inheritance(strategy=InheritanceType.JOINED)
public class UserAccount  {

	
	 // table per subclass strategy
	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
		private int userid;
	
		@Column(name = "emailID")
		private String emailID;
		
		@Column(name = "password")
		private String password;
		
		@Transient
		private String confirmPassword;
		
		@Column(name = "type")
		private String type;
		
		public UserAccount(){
			
			
		}
		
		public UserAccount(String emailID, String password, String confirmPassword ) {
			this.emailID = emailID;
			this.password = password;
			this.confirmPassword = confirmPassword;
		}
		
	
//		public long getUserid() {
//			return userid;
//		}
//
//		public void setUserid(long userid) {
//			this.userid = userid;
//		}
		
		

	
		public String getEmailID() {
			return emailID;
		}

		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
}
