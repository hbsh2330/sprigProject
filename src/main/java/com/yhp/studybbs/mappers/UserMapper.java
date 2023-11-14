package com.yhp.studybbs.mappers;

import com.yhp.studybbs.entities.ContactCompanyEntity;
import com.yhp.studybbs.entities.EmailAuthEntity;
import com.yhp.studybbs.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insertEmailAuth(EmailAuthEntity emailAuth); //delet, insert, updat는 전부 int를 반환한다

    int insertUser(UserEntity entity);
    ContactCompanyEntity[] selectContactCompanies();

//    UserMapper인터페이스의 메소드명이랑 mapper.xml의 id값이랑 일치해야한다.
    EmailAuthEntity selectEmailAuthByEmailCodeSalt(@Param(value = "email") String email, //@Param의 value의 값인 email이 UserMapper.xml의 #{email} 과 같아야한다.
                                                   @Param(value = "code") String code,
                                                   @Param(value = "salt") String salt);

    UserEntity selectUserByContact(@Param(value = "contactFirst") String contact,
                                   @Param(value = "contactSecond") String contactSecond,
                                   @Param(value = "contactThird") String contactThird);

    UserEntity selectUserByNickname(@Param(value = "nickname") String nickname);

    UserEntity selectUserByEmail(@Param(value = "email") String email);

    int updateEmailAuth(EmailAuthEntity emailAuth);
}