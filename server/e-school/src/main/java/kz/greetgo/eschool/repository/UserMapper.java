package kz.greetgo.eschool.repository;

import kz.greetgo.eschool.model.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM app_user WHERE user_name = #{userName}")
    AppUser findByUserName(@Param("userName") String userName);

}
