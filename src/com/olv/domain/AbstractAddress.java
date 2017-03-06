package com.olv.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class AbstractAddress implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private BigDecimal aid;
	private String name;
	private Set<Object> votes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AbstractAddress() {
	}

	/** minimal constructor */
	public AbstractAddress(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractAddress(String name, Set<Object> votes) {
		this.name = name;
		this.votes = votes;
	}

	// Property accessors
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="AIDSEQ")
    @SequenceGenerator(name = "AIDSEQ",sequenceName ="AIDSEQ",allocationSize=1)
	public BigDecimal getAid() {
		return this.aid;
	}

	public void setAid(BigDecimal aid) {
		this.aid = aid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Object> getVotes() {
		return this.votes;
	}

	public void setVotes(Set<Object> votes) {
		this.votes = votes;
	}

}