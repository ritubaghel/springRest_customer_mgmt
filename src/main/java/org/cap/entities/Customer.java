package org.cap.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private int custid;
    private String custname;

    public int getCustId() {
        return custid;
    }

    public void setCustId(int custid) {
        this.custid = custid;
    }

    public String getCustName() {
        return custname;
    }

    public void setCustName(String custname) {
        this.custname = custname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return custid == customer.custid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(custid);
    }
}
