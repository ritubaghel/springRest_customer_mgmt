package org.cap.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomerDto {

    private String custname;


    public String getCustName() {
        return custname;
    }

    public void setCustName(String custname) {
        this.custname = custname;
    }
    

}
