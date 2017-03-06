package com.olv.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class AbstractUsers implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal userid;
	private Byte grade;
	private String username;
	private String password;
	private String tean;
	private Set<Object> themes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}

	/** minimal constructor */
	public AbstractUsers(Byte grade, String username, String password,
			String tean) {
		this.grade = grade;
		this.username = username;
		this.password = password;
		this.tean = tean;
	}

	/** full constructor */
	public AbstractUsers(Byte grade, String username, String password,
			String tean, Set<Object> themes) {
		this.grade = grade;
		this.username = username;
		this.password = password;
		this.tean = tean;
		this.themes = themes;
	}

	// Property accessors
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="UIDSEQ")
    @SequenceGenerator(name = "UIDSEQ",sequenceName ="UIDSEQ",allocationSize=1)
	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public Byte getGrade() {
		return this.grade;
	}

	public void setGrade(Byte grade) {
		this.grade = grade;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTean() {
		return this.tean;
	}

	public void setTean(String tean) {
		this.tean = tean;
	}

	public Set<Object> getThemes() {
		return this.themes;
	}

	public void setThemes(Set<Object> themes) {
		this.themes = themes;
	}

}