package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;

import java.util.List;

@Mapper
public interface BreakfastMapper {

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id, " +
                    "img " +
                    "FROM breakfasts " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', name, tag) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<Breakfast> getBreakfasts(@Param("search") String search);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id, " +
                    "img "+
                    "FROM breakfasts " +
                    "WHERE restaurant_id = #{id}"
    )
    List<Breakfast> findByRestaurantID(@Param("id") int id);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id, " +
                    "img "+
                    "FROM breakfasts " +
                    "WHERE restaurant_id = #{restaurantId} " +
                    "AND CONCAT_WS('$', tag) LIKE CONCAT('%', #{tag:VARCHAR}, '%')"
    )
    List<Breakfast> findByTag(@Param("tag") String tag, @Param("restaurantId") int restaurantId);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id, " +
                    "img "+
                    "FROM breakfasts " +
                    "WHERE name = #{name} " +
                    "OR CONCAT_WS('$', name) LIKE CONCAT('%', #{name:VARCHAR}, '%')"
    )
    List<Breakfast> findByName(@Param("name") String name);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id, " +
                    "img "+
                    "FROM breakfasts " +
                    "WHERE breakfast_id = #{id}"
    )
    Breakfast findById(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE breakfasts " +
                    "SET " +
                    "breakfast_id = #{id}, " +
                    "name = #{name}, " +
                    "tag = #{tag}, " +
                    "price = #{price}, " +
                    "restaurant_id = #{restaurantId}, " +
                    "img = #{img} "+
                    "WHERE breakfast_id = #{id}"
    )
    void update(Breakfast breakfast);

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts " +
                    "WHERE breakfast_id = #{id}"
    )
    void delete(@Param("id") int id);


    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO breakfasts " +
                    "(name, tag, price, restaurant_id, img)" +
                    "VALUES " +
                    "(#{name}, #{tag}, #{price}, #{restaurantId}, #{img})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "breakfast_id",
            statement = "select currval('breakfasts_breakfast_id_seq')",
            resultType = Integer.class)
    void insert(Breakfast breakfast);
}
