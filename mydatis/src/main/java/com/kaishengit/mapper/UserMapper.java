package com.kaishengit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kaishengit.entity.User;


@CacheNamespace
public interface UserMapper {
	
	/*
	 *注解不能完全代替xml配置 
	 */
	@Select("select * from t_user where id = #{id}")
	@Options(useCache=false)
	User findById(Integer id);//禁止缓存 
	
	@Insert("insert into t_user(user_name,user_age,address) values(#{userName},#{userAge},#{address})")
	void save(User user);
	
	@Update("update t_user set user_name = #{userName},user_age = #{userAge},address = #{address} where id = #{id}")
	void update(User user);
	
	@Delete("delete from t_user where id = #{id}")
	void delById(Integer id);
	
	List<User> findAll();
	List<User> findAllLoadDept();
	void updateById(Integer id);
	User findIdByNameAndPassword(@Param("userName") String userName,
								@Param("password")	String password);
	
	User findByMapParam(Map<String,Object> params);
	
	List<User> searchByNameAndAddress(Map<String,Object> params);
	
	void delByIds(List<Integer> id);
	
	void batchSave(List<User> userList);
	
	List<User> findByNameAndPassword(Map<String,Object> params);
	
	List<User> searchByNameAndPassword(Map<String,Object> map);
}
