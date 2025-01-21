package com.app.service_shuffle.model;

import java.io.Serializable;
import java.util.List;

public class ShuffleResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 5497323897346871673L;
	private String message;
	private List<Integer> result;

	public ShuffleResponse() {
		// TODO Auto-generated constructor stub
	}

	public ShuffleResponse(String message, List<Integer> result) {
		this.message = message;
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Integer> getResult() {
		return result;
	}

	public void setResult(List<Integer> result) {
		this.result = result;
	}

}
