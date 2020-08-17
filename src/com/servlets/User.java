package com.servlets;

public class User {

		private int userID;
		private String lastName;
		private String name;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		
		public void print() {
			
			String UserString;
			String UserHeader;
			
			
			UserHeader = "userID | lastName | name | birthDate | eMail | ";
			UserString = this.getUserID() + " | " + this.getLastName() + " | " + this.getName() + " | " + this.getBirthDate() + " | " + this.geteMail() + " | ";
			System.out.println(UserHeader);
			System.out.println(UserString);
			
		}
		
}
