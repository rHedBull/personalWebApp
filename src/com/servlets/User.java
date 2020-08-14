package com.servlets;

public class User {

		private int userID;
		private String lastName;
		private int birthDate;
		private String eMail;		
		
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(int birthDate) {
			this.birthDate = birthDate;
		}
		public String geteMail() {
			return eMail;
		}
		public void seteMail(String eMail) {
			this.eMail = eMail;
		}
		
}
