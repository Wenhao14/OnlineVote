package com.olv.domain;

import java.util.Set;


public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Byte grade, String username, String password, String tean) {
		super(grade, username, password, tean);
	}

	/** full constructor */
	public Users(Byte grade, String username, String password, String tean,
			Set<Object> themes) {
		super(grade, username, password, tean, themes);
	}

}
