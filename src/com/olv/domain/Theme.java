package com.olv.domain;

import java.sql.Timestamp;
import java.util.Set;


public class Theme extends AbstractTheme implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
    public Theme() {
    }

	/** minimal constructor */
    public Theme(Users users, String details, Timestamp lasttime, String state, Byte type) {
        super(users, details, lasttime, state, type);        
    }
    
    /** full constructor */
    public Theme(Users users, String details, Timestamp lasttime, String state, Byte type, Set<Object> optionses) {
        super(users, details, lasttime, state, type, optionses);        
    }
   
}
