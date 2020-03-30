package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(
            "SELECT " +
                    "user_id AS id," +
                    "first_name, " +
                    "last_name, " +
                    "middle_name, " +
                    "username, " +
                    "phone_number, " +
                    "address_id AS address, " +
                    "role_id as role " +
                    "FROM users u " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', first_name, last_name, username) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<User> getUsers(@Param("search") String search);

    @Select("SELECT " +
            "user_id AS id, " +
            "first_name, " +
            "last_name, " +
            "middle_name, " +
            "username, " +
            "phone_number, " +
            "address_id AS address, " +
            "role_id as role " +
            "FROM users u " +
            "WHERE user_id = #{id}")
    User findById(@Param("id") int id);

    @Update("UPDATE users " +
            "SET " +
            "first_name = #{firstName}, " +
            "last_name = #{lastName}, " +
            "middle_name = #{middleName}, " +
            "address_id= #{address}, " +
            "phone_number=#{phoneNumber}, " +
            "username = #{username}, " +
            "password = #{password}, " +
            "role_id = #{role} " +
            "WHERE user_id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(@Param("id") int id);

    /**
     * Поскольку поле ID автоинкрементное, мы можем подсказать MyBatis, что можно взять свежедобавленное значение из
     * последовательности. Для этого используется `SelectKey`
     *
     * @param user
     */
    @Insert("INSERT INTO users (first_name, last_name, middle_name, username, password, role_id, address_id, phone_number) " +
            "VALUES(#{firstName}, #{lastName}, #{middleName}, #{username}, #{password}, #{role}, #{address}, #{phoneNumber})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "user_id",
            statement = "select currval('users_user_id_seq')",
            resultType = Integer.class)
    void insert(User user);
}
