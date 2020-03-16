package ru.relex.tastyfasty.db.mappers;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select(
            "SELECT " +
                    "order_id AS orderID," +
                    "name AS orderID," +
                    "tag AS breakfastID," +
                    "customer_id AS customerID," +
                    "deliveryman_id AS deliverymanID," +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<OrderMapper> getOrders(@Param("search") String search);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE order_id = #{id}")
    OrderMapper findById(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE customer_id = #{id}")
    OrderMapper findCustomerId(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE deliveryman_id = #{id}")
    OrderMapper findDeliverymanId(@Param("id") int id);

    @Update("UPDATE orders_breakfasts " +
            "SET order_id = #{orderBreakfastID}," +
            "name= #{orderID}," +
            "tag= #{breakfastID}," +
            "customer_id= #{customerID}," +
            "deliveryman_id= #{deliverymanID}," +
            "WHERE order_id = #{id}")
    void update(OrderMapper orderMapper);

    @Delete("DELETE FROM orders WHERE order_id = #{orderID}")
    void delete(@Param("orderID") int orderID);


    @Insert("INSERT INTO orders_breakfasts ( order_id, name, tag, customer_id,deliveryman_id,)" +
            "VALUES(#{orderID}, #{name},  #{tag},  #{customerID},  #{deliverymanID}")
    void insert(OrderMapper orderMapper);
}
