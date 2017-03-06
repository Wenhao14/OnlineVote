package com.olv.domain;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


public abstract class AbstractVote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private BigDecimal vid;
	private Address address;
	private Options options;

	// Constructors

	/** default constructor */
	public AbstractVote() {
	}

	/** full constructor */
	public AbstractVote(Address address, Options options) {
		this.address = address;
		this.options = options;
	}

	// Property accessors
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIDSEQ")
    @SequenceGenerator(name = "VIDSEQ",sequenceName ="VIDSEQ",allocationSize=1)
	public BigDecimal getVid() {
		return this.vid;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIDSEQ")
    @SequenceGenerator(name = "VIDSEQ",sequenceName ="VIDSEQ",allocationSize=1)
	public void setVid(BigDecimal vid) {
		this.vid = vid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Options getOptions() {
		return this.options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

}