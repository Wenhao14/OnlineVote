package com.olv.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


public abstract class AbstractOptions implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private BigDecimal oid;
	private Theme theme;
	private String details;
	private String introduction;
	private String key;
	private Set<Object> votes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AbstractOptions() {
	}

	/** minimal constructor */
	public AbstractOptions(Theme theme, String details,String introduction, String key) {
		this.theme = theme;
		this.details = details;
		this.introduction=introduction;
		this.key=key;
	}

	/** full constructor */
	public AbstractOptions(Theme theme, String details,String introduction ,String key,Set<Object> votes) {
		this.theme = theme;
		this.details = details;
		this.introduction=introduction;
		this.key=key;
		this.votes = votes;
	}

	// Property accessors
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="OIDSEQ")
    @SequenceGenerator(name = "OIDSEQ",sequenceName ="OIDSEQ",allocationSize=1)
	public BigDecimal getOid() {
		return this.oid;
	}

	public void setOid(BigDecimal oid) {
		this.oid = oid;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Set<Object> getVotes() {
		return this.votes;
	}

	public void setVotes(Set<Object> votes) {
		this.votes = votes;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}