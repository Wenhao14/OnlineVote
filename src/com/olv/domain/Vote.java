package com.olv.domain;

public class Vote extends AbstractVote implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Vote() {
	}

	/** full constructor */
	public Vote(Address address, Options options) {
		super(address, options);
	}

}
