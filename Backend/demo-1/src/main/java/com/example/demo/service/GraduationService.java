package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Graduation;

public interface GraduationService {
	List<Graduation> searchGrad(String query);
}
