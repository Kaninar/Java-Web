package com.main.hw.models;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//
//import java.io.Serializable;
//
////@JacksonXmlRootElement
public class Tariff implements Comparable<Tariff>
{
    public String Name;
    public String Operator_name;
    public Float Payroll;
    public CallPrices CallPrices;
    public Float SMS_price;
    public Parameters Parameters;

    public Tariff(String name, String operator_name, Float payroll, com.main.hw.models.CallPrices callPrices, Float SMS_price, com.main.hw.models.Parameters parameters) {
        this.Name = name;
        Operator_name = operator_name;
        Payroll = payroll;
        CallPrices = callPrices;
        this.SMS_price = SMS_price;
        Parameters = parameters;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOperator_name() {
        return Operator_name;
    }

    public void setOperator_name(String operator_name) {
        Operator_name = operator_name;
    }

    public Float getPayroll() {
        return Payroll;
    }

    public void setPayroll(Float payroll) {
        Payroll = payroll;
    }

    public com.main.hw.models.CallPrices getCallPrices() {
        return CallPrices;
    }

    public void setCallPrices(com.main.hw.models.CallPrices callPrices) {
        CallPrices = callPrices;
    }

    public Float getSMS_price() {
        return SMS_price;
    }

    public void setSMS_price(Float SMS_price) {
        this.SMS_price = SMS_price;
    }

    public com.main.hw.models.Parameters getParameters() {
        return Parameters;
    }

    public void setParameters(com.main.hw.models.Parameters parameters) {
        Parameters = parameters;
    }

    public int compareTo(Tariff o) {
        return this.Payroll.compareTo(o.Payroll);
    }

}

