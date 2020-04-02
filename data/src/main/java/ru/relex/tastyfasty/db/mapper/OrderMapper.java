package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_id AS orderID, " +
                    "name, " +
                    "tag, " +
                    "status_id AS status, " +
                    "price AS price, " +
                    "customer_id AS customerID, " +
                    "deliveryman_id AS deliverymanID " +
                    "FROM orders " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Order> getOrders(@Param("search") String search);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_id AS orderID, " +
                    "name, " +
                    "tag, " +
                    "status_id AS status, " +
                    "price AS price, " +
                    "customer_id AS customerID, " +
                    "deliveryman_id AS deliverymanID " +
                    "FROM orders " +
                    "WHERE customer_id = #{id}"
    )
    List<Order> findByCustomerId(@Param("id") int id);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_id AS orderID, " +
                    "name, " +
                    "tag, " +
                    "status_id AS status, " +
                    "price AS price, " +
                    "customer_id AS customerID, " +
                    "deliveryman_id AS deliverymanID " +
                    "FROM orders " +
                    "WHERE deliveryman_id = #{id}"
    )
    List<Order> findByDeliverymanId(@Param("id") int id);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "order_id AS orderID, " +
                    "name, " +
                    "tag, " +
                    "status_id AS status, " +
                    "price AS price, " +
                    "customer_id AS customerID, " +
                    "deliveryman_id AS deliverymanID " +
                    "FROM orders " +
                    "WHERE order_id = #{id}"
    )
    Order findById(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE orders " +
                    "SET order_id = #{orderID}, " +
                    "name = #{name}, " +
                    "tag = #{tag}, " +
                    "price = #{price}, " +
                    "status_id= #{status}, " +
                    "customer_id = #{customerID}, " +
                    "deliveryman_id = #{deliverymanID} " +
                    "WHERE order_id = #{orderID}"
    )
    void update(Order order);

    @Delete(//language=PostgreSQL
            "DELETE FROM orders " +
                    "WHERE order_id = #{orderID}"
    )
    void delete(@Param("orderID") int orderID);

    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO orders " +
                    "(name, tag, status_id, customer_id, deliveryman_id, price) " +
                    "VALUES " +
                    "(#{name}, #{tag}, #{status}, #{customerID}, #{deliverymanID}, #{price})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "order_id",
            statement = "select currval('orders_order_id_seq')",
            resultType = Integer.class)
    void insert(Order order);
}
