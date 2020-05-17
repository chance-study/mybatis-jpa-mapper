package org.chance.sample.boot.dao;

import org.apache.ibatis.annotations.Mapper;

import org.chance.jpamapper.core.mapper.CrudMapper;
import org.chance.sample.boot.domain.UserInfoUnion;

@Mapper
public interface UserInfoUnionDao extends CrudMapper<UserInfoUnion, String> {
	
}