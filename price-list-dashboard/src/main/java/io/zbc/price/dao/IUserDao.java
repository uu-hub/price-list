package io.zbc.price.dao;

import io.zbc.price.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IUserDao {

    @Select("SELECT * FROM `user`WHERE user_name = #{userName} AND password = #{password}")
    User selectUserByNameAndPassword(User user);

    @Select("SELECT * FROM user WHERE user_name = #{userName}")
    User selectUserByName(String userName);

    @Insert("INSERT INTO user (user_name, password, email, mobile, user_type, update_time) " +
            "VALUES (#{userName}, #{password}, #{email}, #{mobile}, 0, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int insertUser(User user);

    @Select("create TABLE IF NOT EXISTS `user` ( " +
            "user_id integer(4) NOT NULL AUTO_INCREMENT, " +
            "user_name varchar(255) NOT NULL, " +
            "password varchar(255) DEFAULT NULL, " +
            "token varchar(255) DEFAULT NULL, " +
            "avatar varchar(255) DEFAULT NULL, " +
            "email varchar(255) DEFAULT NULL, " +
            "mobile varchar(20) DEFAULT NULL, " +
            "user_type integer(4) NOT NULL, " +
            "update_time datetime(0) NOT NULL, " +
            "PRIMARY KEY (user_id), " +
            "UNIQUE KEY `user_name` (user_name) " +
            ") ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;")
    void createUserTable();

}
