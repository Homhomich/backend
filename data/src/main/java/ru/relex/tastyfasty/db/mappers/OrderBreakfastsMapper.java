package ru.relex.tastyfasty.db.mappers;

import org.apache.ibatis.annotations.*;

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
    List<OrderBreakfastsMapper> getOrdersBreakfasts(@Param("search") String search);

    @Select("SELECT " +
            "order_breakfast_id AS orderBreakfastID," +
            "order_id AS orderID," +
            "breakfast_id AS breakfastID," +
            "FROM orders_breakfasts rest " +
            "WHERE order_breakfast_id = #{id}")
    OrderBreakfastsMapper findById(@Param("id") int id);

    @Select("SELECT " +
            "order_breakfast_id AS orderBreakfastID," +
            "order_id AS orderID," +
            "breakfast_id AS breakfastID," +
            "FROM orders_breakfasts rest " +
            "WHERE order_id = #{id}")
    OrderBreakfastsMapper findByOrderId(@Param("id") int id);

    @Update("UPDATE orders_breakfasts " +
            "SET order_breakfast_id = #{orderBreakfastID}," +
            "order_id= #{orderID}," +
            "breakfast_id= #{breakfastID}," +
            "WHERE order_breakfast_id = #{id}")
    void update(OrderBreakfastsMapper orderBreakfastsMapper);

    @Delete("DELETE FROM orders_breakfasts WHERE order_breakfast_id = #{orderBreakfastID}")
    void delete(@Param("orderBreakfastID") int orderBreakfastID);


    @Insert("INSERT INTO orders_breakfasts ( order_breakfast_id, order_id, breakfast_id)" +
            "VALUES(#{orderBreakfastID}, #{orderID},  #{breakfastID}")
    void insert(OrderBreakfastsMapper orderBreakfastsMapper);
}
