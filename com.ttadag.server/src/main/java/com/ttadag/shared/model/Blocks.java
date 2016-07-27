package com.ttadag.shared.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Deprecated
@Document
public class Blocks extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1997664670572176178L;
	
	public @Setter @Getter String key;
	public @Setter @Getter String only;
	public @Setter @Getter String type;
	public @Setter @Getter String category;
	public @Setter @Getter String spec;
	public @Setter @Getter Object[] defaults;
	public @Setter @Getter String dev;
	
}
