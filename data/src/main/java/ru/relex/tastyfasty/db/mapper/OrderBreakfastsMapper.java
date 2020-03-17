package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.OrderBreakfasts;

import java.util.List;

@Mapper
public interface OrderBreakfastsMapper {
    @Select(
            "SELECT " +
                    "order_breakfast_id AS orderBreakfastID," +
                    "order_id AS orderID," +
                    "breakfast_id AS breakfastID," +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<OrderBreakfasts> getOrdersBreakfasts(@Param("search") String search);

    @Select("SELECT " +
            "order_breakfast_id AS orderBreakfastID," +
            "order_id AS orderID," +
            "breakfast_id AS breakfastID," +
            "FROM orders_breakfasts rest " +
            "WHERE order_breakfast_id = #{id}")
    OrderBreakfasts findById(@Param("orderBreakfastID") int id);

    @Select("SELECT " +
            "order_breakfast_id AS orderBreakfastID," +
            "order_id AS orderID," +
            "breakfast_id AS breakfastID," +
            "FROM orders_breakfasts rest " +
            "WHERE order_id = #{id}")
    OrderBreakfasts findByOrderId(@Param("orderID") int id);

    @Update("UPDATE orders_breakfasts " +
            "SET order_breakfast_id = #{orderBreakfastID}," +
            "order_id= #{orderID}," +
            "breakfast_id= #{breakfastID}," +
            "WHERE order_breakfast_id = #{id}")
    void update(OrderBreakfasts orderBreakfasts);

    @Delete("DELETE FROM orders_breakfasts WHERE order_breakfast_id = #{orderBreakfastID}")
    void delete(@Param("orderBreakfastID") int orderBreakfastID);


    @Insert("INSERT INTO orders_breakfasts ( order_breakfast_id, order_id, breakfast_id)" +
            "VALUES(#{orderBreakfastID}, #{orderID},  #{breakfastID}")
    void insert(OrderBreakfasts orderBreakfasts);
}
