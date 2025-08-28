package org.uday.task2.model;

public class Engine {
	public Engine(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;
	
	public void start() {
		System.out.println("Engine Type: "+type+" is stating...");
	}
	

}
