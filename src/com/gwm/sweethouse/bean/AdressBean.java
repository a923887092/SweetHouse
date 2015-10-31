package com.gwm.sweethouse.bean;

public class AdressBean {
	

    String add_name;
    String add_address;
    String add_phone;
    public AdressBean() {
		super();
	}

	


    public String getadd_name() {
        return add_name;
    }

    public void setadd_name(String add_name) {
        this.add_name = add_name;
    }

    public String getAdd_address() {
        return add_address;
    }

    public void setAdd_address(String add_address) {
        this.add_address = add_address;
    }

    public String getAdd_phone() {
        return add_phone;
    }

    public void setAdd_phone(String add_phone) {
        this.add_phone = add_phone;
    }

    public AdressBean(String add_phone, String add_address, String add_name) {
		super();		
		this.add_phone = add_phone;
		this.add_address = add_address;
		this.add_name = add_name;		
	}




}
