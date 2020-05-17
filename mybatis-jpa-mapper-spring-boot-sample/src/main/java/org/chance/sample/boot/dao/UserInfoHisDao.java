package org.chance.sample.boot.dao;

import org.apache.ibatis.annotations.Mapper;

import org.chance.jpamapper.core.mapper.SimpleShardingMapper;
import org.chance.sample.boot.domain.UserInfoHis;

@Mapper
public interface UserInfoHisDao extends SimpleShardingMapper<UserInfoHis, String> {
	
}