 package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.error.DoctorNotFoundException;
import com.nit.repository.IDoctorRepo;
import com.nit.vo.DoctorVo;
@Service
public class IDoctorImplmt implements IDoctorMgmtService
{
	@Autowired
	IDoctorRepo doctorRepo;

	
	@Override
	public List<DoctorVo> findAllDoctors() 
	{
		List<Doctor> listEntity = doctorRepo.findAll();
		List<DoctorVo> listVo = new ArrayList<DoctorVo>();
		listEntity.forEach(entity ->{
			DoctorVo vo = new DoctorVo();
			BeanUtils.copyProperties(entity, vo);
			listVo.add(vo);
		});
		return listVo;
	}


	@Override
	public String registerDoctor(DoctorVo vo) 
	{
		//convert vo class obj to entity clas  obj
		Doctor entity = new Doctor();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		//use repo
		int idVal=doctorRepo.save(entity).getDid();
		
		
		return "Doctor is registered with id value "+idVal ;
	}


	@Override
	public DoctorVo showDoctorById(int id) 
	{
		Doctor entity = doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		DoctorVo vo = new DoctorVo();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}


	@Override
	public String editDoctor(DoctorVo vo) 
	{
		//convert vo to entity obj
		Doctor entity = doctorRepo.findById(vo.getDid()).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		BeanUtils.copyProperties(vo, entity);
		//update the obj
		doctorRepo.save(entity);
		return vo.getDid()+" Doctors Details are updated";
	}


	@Override
	public String removeDoctor(int id)
	{
		Doctor entity = doctorRepo.findById(id).orElseThrow(()-> new DoctorNotFoundException("Invalid Doctor Id"));
		doctorRepo.deleteById(id);
		return id+" Id Doctor is Deleted";
	}

}
