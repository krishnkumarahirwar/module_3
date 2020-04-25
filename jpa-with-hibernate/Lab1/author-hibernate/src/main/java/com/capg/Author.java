package com.capg;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author-table")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int authorId;
	public String authorFirstName;
	public String authorMiddleName;
	public String authorLastName;
	public String authorPhoneNum;
	public Author() {
		
	}
	
	
	public Author(int authorId, String authorFirstName, String authorMiddleName, String authorLastName,
			String authorPhoneNum) {
		this.authorId = authorId;
		this.authorFirstName = authorFirstName;
		this.authorMiddleName = authorMiddleName;
		this.authorLastName = authorLastName;
		this.authorPhoneNum = authorPhoneNum;
	}


	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorMiddleName() {
		return authorMiddleName;
	}
	public void setAuthorMiddleName(String authorMiddleName) {
		this.authorMiddleName = authorMiddleName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getAuthorPhoneNum() {
		return authorPhoneNum;
	}
	public void setAuthorPhoneNum(String authorPhoneNum) {
		this.authorPhoneNum = authorPhoneNum;
	}
	
	

}
