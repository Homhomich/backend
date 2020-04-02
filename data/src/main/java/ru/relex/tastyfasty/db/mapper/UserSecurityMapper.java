package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.relex.tastyfasty.db.model.UserSecurityDetails;

@Mapper
public interface UserSecurityMapper {
    @Select(//language=PostgreSQL
            "SELECT user_id AS id, " +
                    " username AS username, " +
                    " password AS password, " +
                    " u.role_id AS role, " +
                    " array_agg(rp.permission_id) AS permissions " +
                    "FROM users u " +
                    "LEFT JOIN role_permissions rp ON u.role_id = rp.role_id " +
                    "WHERE username = #{username} " +
                    "GROUP BY user_id, username, password, u.role_id"

    )
    UserSecurityDetails findUserByUsername(String username);
}
