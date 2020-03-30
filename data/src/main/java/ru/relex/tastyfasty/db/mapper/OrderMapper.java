package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select(
            "SELECT " +
                    "order_id AS orderID, " +
                    "name AS orderID, " +
                    "tag AS breakfastID, " +
                    "status_id AS status, " +
                    "price AS price, " +
                    "customer_id AS customerID, " +
                    "deliveryman_id AS deliverymanID " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Order> getOrders(@Param("search") String search);

    @Select("SELECT " +
            "order_id AS orderID, " +
            "name AS orderID, " +
            "tag AS breakfastID, " +
            "status_id AS status, " +
            "price AS price, " +
            "customer_id AS customerID, " +
            "deliveryman_id AS deliverymanID " +
            "WHERE order_id = #{id}")
    Order findById(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID, " +
            "name AS orderID, " +
            "tag AS breakfastID, " +
            "status_id AS status, " +
            "price AS price, " +
            "customer_id AS customerID, " +
            "deliveryman_id AS deliverymanID, " +
            "WHERE customer_id = #{id}")
    Order findByCustomerId(@Param("id") int id);

    @Select("SELECT " +
            "order_id AS orderID, " +
            "name AS orderID, " +
            "tag AS breakfastID, " +
            "status_id AS status, " +
            "price AS price, " +
            "customer_id AS customerID, " +
            "deliveryman_id AS deliverymanID " +
            "WHERE deliveryman_id = #{id}")
    Order findByDeliverymanId(@Param("id") int id);

    @Update("UPDATE orders_breakfasts " +
            "SET order_id = #{orderBreakfastID}, " +
            "name= #{orderID}, " +
            "tag= #{breakfastID}, " +
            "price =#{price}, " +
            "status_id= #{status}, " +
            "customer_id= #{customerID}, " +
            "deliveryman_id= #{deliverymanID} " +
            "WHERE order_id = #{id}")
    void update(Order order);

    @Delete("DELETE FROM orders WHERE order_id = #{orderID}")
    void delete(@Param("orderID") int orderID);

    @Insert("INSERT INTO orders_breakfasts ( order_id, name, tag, status_id customer_id, deliveryman_id,)" +
            "VALUES(#{orderID}, #{name}, #{tag}, #{status}, #{customerID}, #{deliverymanID}, #{price}")
    void insert(Order order);
}
