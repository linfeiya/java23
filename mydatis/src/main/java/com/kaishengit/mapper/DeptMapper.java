package com.kaishengit.mapper;

import com.kaishengit.entity.Dept;

public interface DeptMapper {
	Dept findByIdLoadMapper(Integer id);
}
