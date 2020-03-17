package ru.relex.tastyfasty.db.mappers;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.models.Order;

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
    List<Order> getOrders(@Param("search") String search);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE order_id = #{id}")
    Order findById(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE customer_id = #{id}")
    Order findByCustomerId(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID," +
            "name AS orderID," +
            "tag AS breakfastID," +
            "customer_id AS customerID," +
            "deliveryman_id AS deliverymanID," +
            "WHERE deliveryman_id = #{id}")
    Order findByDeliverymanId(@Param("id") int id);

    @Update("UPDATE orders_breakfasts " +
            "SET order_id = #{orderBreakfastID}," +
            "name= #{orderID}," +
            "tag= #{breakfastID}," +
            "customer_id= #{customerID}," +
            "deliveryman_id= #{deliverymanID}," +
            "WHERE order_id = #{id}")
    void update(Order order);

    @Delete("DELETE FROM orders WHERE order_id = #{orderID}")
    void delete(@Param("orderID") int orderID);


    @Insert("INSERT INTO orders_breakfasts ( order_id, name, tag, customer_id,deliveryman_id,)" +
            "VALUES(#{orderID}, #{name},  #{tag},  #{customerID},  #{deliverymanID}")
    void insert(Order order);
}
