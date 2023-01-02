package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Graduation;
import com.example.demo.entity.Job;
import com.example.demo.repository.GraduationRepository;
import com.example.demo.repository.JobRepository;

@Service
public class GraduationServiceImpl implements GraduationService{
	
	@Autowired
	private GraduationRepository graduationRepository;	
	
	private List<Graduation> graduations;

	public GraduationServiceImpl(GraduationRepository graduationRepository) {
		super();
		this.graduationRepository = graduationRepository;
	}

	public GraduationServiceImpl() {
		super();
	}

	@PostConstruct
	private void publi() {
		this.graduations = new ArrayList<>();
	}
	
	@Override
	public List<Graduation> searchGrad(String query) {
		List<Graduation> graduations = graduationRepository.searchGrad(query);
		return graduations;
	}

}
