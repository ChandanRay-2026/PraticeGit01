package com.nit.service;

import java.util.List;

import com.nit.entity.Doctor;
import com.nit.vo.DoctorVo;

public interface IDoctorMgmtService 
{
	public List<DoctorVo> findAllDoctors();
   public String registerDoctor(DoctorVo vo);
   public DoctorVo showDoctorById(int id);
   public String editDoctor(DoctorVo vo);
   public String removeDoctor(int id);
   
}
