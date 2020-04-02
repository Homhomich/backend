package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.OrderBreakfasts;

import java.util.List;

@Mapper
public interface OrderBreakfastsMapper {

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "order_breakfast_id AS orderBreakfastID, " +
                    "order_id AS orderID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM orders_breakfasts " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<OrderBreakfasts> getOrdersBreakfasts(@Param("search") String search);*/

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_breakfast_id AS orderBreakfastID, " +
                    "order_id AS orderID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM orders_breakfasts " +
                    "WHERE order_id = #{orderId}"
    )
    List<OrderBreakfasts> findByOrderId(@Param("orderId") int orderId);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_breakfast_id AS orderBreakfastID, " +
                    "order_id AS orderID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM orders_breakfasts " +
                    "WHERE order_breakfast_id = #{id}"
    )
    OrderBreakfasts findById(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE orders_breakfasts " +
                    "SET order_breakfast_id = #{orderBreakfastID}, " +
                    "order_id= #{orderID}, " +
                    "breakfast_id= #{breakfastID} " +
                    "WHERE order_breakfast_id = #{orderBreakfastID}"
    )
    void update(OrderBreakfasts orderBreakfasts);

    @Delete(//language=PostgreSQL
            "DELETE FROM orders_breakfasts " +
                    "WHERE order_id = #{orderID}")
    void deleteByOrderId(@Param("orderID") int orderID);

    @Delete(//language=PostgreSQL
            "DELETE FROM orders_breakfasts " +
                    "WHERE order_id = #{orderId} AND breakfast_id = #{breakfastId}")
    void deleteBreakfastFromOrder(@Param("orderId") int orderId, @Param("breakfastId") int breakfastId);

    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO orders_breakfasts " +
                    "(order_id, breakfast_id)" +
                    "VALUES " +
                    "(#{orderID}, #{breakfastID})"
    )
    @SelectKey(
            before = false,
            keyProperty = "orderBreakfastID",
            keyColumn = "order_breakfast_id",
            statement = "select currval('orders_breakfasts_order_breakfast_id_seq')",
            resultType = Integer.class)
    void insert(OrderBreakfasts orderBreakfasts);
}
