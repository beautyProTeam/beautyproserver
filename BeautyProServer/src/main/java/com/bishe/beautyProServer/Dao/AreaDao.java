package com.bishe.beautyProServer.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bishe.beautyProServer.Pojo.AreaPojo;
@Repository
public interface AreaDao {
//	public int createUser(UserPojo user);
	
	/*根据条件动态查询地区*/
	public AreaPojo selectArea(Map map);
	
	public List<AreaPojo> selectAreaList(Map map);
	
	/*根据条件修改用户信息*/
//	public int updateUser(Map map);
}
