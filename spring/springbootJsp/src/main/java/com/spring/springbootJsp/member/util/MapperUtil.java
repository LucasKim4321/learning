package com.spring.springbootJsp.member.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;

public enum MapperUtil {
	
	INSTANCD;
	
	private ModelMapper modelMapper;
	
	// 생성자
	MapperUtil(){
		this.modelMapper = new ModelMapper();
		this.modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		
	}
	public ModelMapper get() {
		return modelMapper;
	}

}
