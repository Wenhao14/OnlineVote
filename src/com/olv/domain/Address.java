package com.olv.domain;

import java.util.Set;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
public class Address extends AbstractAddress implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String name) {
		super(name);
	}

	/** full constructor */
	public Address(String name, Set<Object> votes) {
		super(name, votes);
	}

}
