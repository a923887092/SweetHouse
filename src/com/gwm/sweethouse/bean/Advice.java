package com.gwm.sweethouse.bean;

public class Advice {
	private int advice_id;
	private String advice_type;
	private String advice_content;
	private String contact_type;
	private int user_id;

	public int getAdvice_id() {
		return advice_id;
	}

	public void setAdvice_id(int adviceId) {
		advice_id = adviceId;
	}

	public String getAdvice_type() {
		return advice_type;
	}

	public void setAdvice_type(String adviceType) {
		advice_type = adviceType;
	}

	public String getAdvice_content() {
		return advice_content;
	}

	public void setAdvice_content(String adviceContent) {
		advice_content = adviceContent;
	}

	public String getContact_type() {
		return contact_type;
	}

	public void setContact_type(String contactType) {
		contact_type = contactType;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public Advice(int adviceId, String adviceType, String adviceContent,
			String contactType, int userId) {
		super();
		advice_id = adviceId;
		advice_type = adviceType;
		advice_content = adviceContent;
		contact_type = contactType;
		user_id = userId;
	}

	public Advice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Advice [advice_content=" + advice_content + ", advice_id="
				+ advice_id + ", advice_type=" + advice_type
				+ ", contact_type=" + contact_type + ", user_id=" + user_id
				+ "]";
	}

}
