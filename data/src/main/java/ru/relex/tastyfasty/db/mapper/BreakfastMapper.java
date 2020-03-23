package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;

import java.util.List;

@Mapper
public interface BreakfastMapper {
    @Select(
            "SELECT " +
                    "breakfast_id AS breakfastID," +
                    "name," +
                    "tag," +
                    "price," +
                    "restaurant_id AS  as restaurantID" +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Breakfast> getBreakfasts(@Param("search") String search);

    @Select("SELECT " +
            "breakfast_id AS breakfastID," +
            "name," +
            "tag," +
            "price," +
            "restaurant_id  AS restaurantID" +
            "WHERE breakfast_id = #{id}")
    BreakfastMapper findById(@Param("id") int id);

    @Select("SELECT " +
            "breakfast_id AS breakfastID," +
            "name," +
            "tag," +
            "price," +
            "restaurant_id  AS restaurantID" +
            "WHERE restaurant_id = #{id}")
    BreakfastMapper findByRestaurantID(@Param("id") int id);

    @Select("SELECT " +
            "breakfast_id AS breakfastID," +
            "name," +
            "tag," +
            "price," +
            "restaurant_id AS restaurantID" +
            "WHERE name = #{name}")
    BreakfastMapper findBreakfastByName(@Param("name") int name);

    @Update("UPDATE orders_breakfasts " +
            "SET order_id = #{breakfastID}," +
            "name= #{name}," +
            "tag= #{tag}," +
            "price= #{price}," +
            "WHERE order_id = #{id}")
    void update(Breakfast breakfast);

    @Delete("DELETE FROM orders WHERE order_id = #{breakfastID}")
    void delete(@Param("breakfastID") int breakfastID);


    @Insert("INSERT INTO orders_breakfasts ( order_id, name, tag, price,restaurant_id)" +
            "VALUES(#{orderID}, #{name},  #{tag},  #{price}, #{restaurantID}")
    void insert(Breakfast breakfast);
}
