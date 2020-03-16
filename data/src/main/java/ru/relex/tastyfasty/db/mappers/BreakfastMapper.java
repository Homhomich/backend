package ru.relex.tastyfasty.db.mappers;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BreakfastMapper {
    @Select(
            "SELECT " +
                    "breakfast_id AS breakfastID," +
                    "name," +
                    "tag," +
                    "price," +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<BreakfastMapper> getBreakfasts(@Param("search") String search);

    @Select("SELECT " +
            "breakfast_id AS breakfastID," +
            "name," +
            "tag," +
            "price," +
            "WHERE breakfast_id = #{id}")
    BreakfastMapper findById(@Param("id") int id);

    @Select("SELECT " +
            "breakfast_id AS breakfastID," +
            "name," +
            "tag," +
            "price," +
            "WHERE name = #{name}")
    BreakfastMapper findBreakfastByName(@Param("name") int name);

    @Update("UPDATE orders_breakfasts " +
            "SET order_id = #{breakfastID}," +
            "name= #{name}," +
            "tag= #{tag}," +
            "price= #{price}," +
            "WHERE order_id = #{id}")
    void update(BreakfastMapper orderMapper);

    @Delete("DELETE FROM orders WHERE order_id = #{breakfastID}")
    void delete(@Param("breakfastID") int breakfastID);


    @Insert("INSERT INTO orders_breakfasts ( order_id, name, tag, price)" +
            "VALUES(#{orderID}, #{name},  #{tag},  #{price}")
    void insert(BreakfastMapper breakfastMapper);
}
