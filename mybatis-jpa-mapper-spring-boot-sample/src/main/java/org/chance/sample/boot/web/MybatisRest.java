package org.chance.sample.boot.web;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.chance.sample.boot.domain.UserInfoUnion;
import org.chance.sample.boot.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.chance.sample.boot.dao.UserRoleDao;

@RestController
@RequestMapping("/my")
public class MybatisRest {
	@Autowired
	UserRoleDao userRoleDao;
	
	@RequestMapping("/selectAll")
	public List<UserRole> findOne(){
		return userRoleDao.selectAll();
	}
	
	@RequestMapping("/selectAllTest")
	public List<UserRole> findAll(){
		RowBounds rowBounds = new RowBounds(0,2);
		return userRoleDao.selectPage(rowBounds);
	}
	
	@RequestMapping("/selectJoin")
	public UserInfoUnion selectJion(){
		return userRoleDao.selectJion("cff");
	}
}
