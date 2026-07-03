package com.nit.vo;

import lombok.Data;

@Data
public class DoctorVo 
{
	private int did;
	private String dname;
    private String specialization;
    private double fee;
    private String qlfy="MBBS";
}
