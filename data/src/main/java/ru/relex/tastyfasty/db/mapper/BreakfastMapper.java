package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;

import java.util.List;

@Mapper
public interface BreakfastMapper {
    @Select(
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Breakfast> getBreakfasts(@Param("search") String search);

    @Select(
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts " +
                    "WHERE breakfast_id = #{id}"
    )
    Breakfast findById(@Param("id") int id);

    @Select(
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts " +
                    "WHERE restaurant_id = #{id}"
    )
    List<Breakfast> findByRestaurantID(@Param("id") int id);

    @Select(
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts " +
                    "WHERE tag = #{tag} AND restaurant_id = #{restaurantId}"
    )
    List<Breakfast> findByTag(@Param("tag") String tag, @Param("restaurantId") int restaurantId);

    @Select(
            "SELECT " +
                    "breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts " +
                    "WHERE name = #{name}"
    )
    List<Breakfast> findByName(@Param("name") String name);

    @Update(
            "UPDATE breakfasts " +
                    "SET " +
                    "breakfast_id = #{id}, " +
                    "name = #{name}, " +
                    "tag = #{tag}, " +
                    "price = #{price}, " +
                    "restaurant_id = #{restaurantId} " +
                    "WHERE breakfast_id = #{id}"
    )
    void update(Breakfast breakfast);

    @Delete(
            "DELETE FROM breakfasts " +
                    "WHERE breakfast_id = #{id}"
    )
    void delete(@Param("id") int id);


    @Insert(
            "INSERT " +
                    "INTO breakfasts " +
                    "(name, tag, price, restaurant_id)" +
                    "VALUES " +
                    "(#{name}, #{tag}, #{price}, #{restaurantId})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "breakfast_id",
            statement = "select currval('breakfasts_breakfast_id_seq')",
            resultType = Integer.class)
    void insert(Breakfast breakfast);
}
