package com.jing.ssm.mybatis.ch0;

import com.jing.ssm.mybatis.ch0.mapper.RoleMapper;
import com.jing.ssm.mybatis.ch0.pojo.Role;
import com.jing.ssm.mybatis.ch0.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Ch0Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Ch0Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
            Role newRole = new Role();
            newRole.setNote("note");
            newRole.setRoleName("Tole");
            int i = roleMapper.insertRole(newRole);
            log.info(i);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
