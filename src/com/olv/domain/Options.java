package com.olv.domain;

import java.util.Set;

/**
 * Options entity. @author MyEclipse Persistence Tools
 */
public class Options extends AbstractOptions implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Options() {
	}

	/** minimal constructor */
	public Options(Theme theme, String details,String introduction,String key) {
		super(theme, details,introduction,key);
	}

	/** full constructor */
	public Options(Theme theme, String details, String introduction,String key,Set<Object> votes) {
		super(theme, details,introduction,key,votes);
	}

}
