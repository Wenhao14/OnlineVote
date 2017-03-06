package com.olv.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class AbstractTheme implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal tid;
	private Users users;
	private String details;
	private Timestamp lasttime;
	private String state;
	private Byte type;
	private Set<Object> optionses = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AbstractTheme() {
	}

	/** minimal constructor */
	public AbstractTheme(Users users, String details, Timestamp lasttime,
			String state, Byte type) {
		this.users = users;
		this.details = details;
		this.lasttime = lasttime;
		this.state = state;
		this.type = type;
	}

	/** full constructor */
	public AbstractTheme(Users users, String details, Timestamp lasttime,
			String state, Byte type, Set<Object> optionses) {
		this.users = users;
		this.details = details;
		this.lasttime = lasttime;
		this.state = state;
		this.type = type;
	}

	// Property accessors
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TIDSEQ")
    @SequenceGenerator(name = "TIDSEQ",sequenceName ="TIDSEQ",allocationSize=1)
	public BigDecimal getTid() {
		return this.tid;
	}

	public void setTid(BigDecimal tid) {
		this.tid = tid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Byte getType() {
		return this.type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Set<Object> getOptionses() {
		return this.optionses;
	}

	public void setOptionses(Set<Object> optionses) {
		this.optionses = optionses;
	}
    
}