package org.chance.sample.boot.web;

import java.util.ArrayList;
import java.util.List;

import org.chance.sample.boot.domain.UserInfoUnion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.chance.sample.boot.dao.UserInfoUnionDao;

@RestController
@RequestMapping("/join")
public class JoinRest {
	@Autowired
	UserInfoUnionDao userInfoDao;
	
	@RequestMapping("/findAll")
	public List<UserInfoUnion> findAll(){
		return (List<UserInfoUnion>) userInfoDao.findAll();
	}
	
	@RequestMapping("/findBatch")
	public List<UserInfoUnion> findBatch(){
		List<String> userNames = new ArrayList<>();
		userNames.add("admin");
		userNames.add("cff");
		return (List<UserInfoUnion>) userInfoDao.findBatch(userNames);
	}
}
