package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Restaurant;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    @Select(//language=PostgreSQL
            "SELECT " +
                    "restaurant_id, " +
                    "name, "  +
                    "rating, " +
                    "open_time, " +
                    "close_time, " +
                    "address_id AS address, " +
                    "tags " +
                    "FROM restaurants " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', name, rating, tags) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<Restaurant> getRestaurants(@Param("search") String search);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "restaurant_id, " +
                    "name, "  +
                    "rating, " +
                    "open_time, " +
                    "close_time, " +
                    "address_id AS address, " +
                    "tags " +
                    "FROM restaurants " +
                    "WHERE name = #{name:VARCHAR} " +
                    "OR CONCAT_WS('$', name) LIKE CONCAT('%', #{name:VARCHAR}, '%')"
    )
    List<Restaurant> getRestaurantsByName(@Param("name") String name);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "restaurant_id, " +
                    "name, "  +
                    "rating, " +
                    "open_time, " +
                    "close_time, " +
                    "address_id AS address, " +
                    "tags " +
                    "FROM restaurants " +
                    "WHERE tags = #{tags:VARCHAR} " +
                    "OR CONCAT_WS('$', tags) LIKE CONCAT('%', #{tags:VARCHAR}, '%')"
    )
    List<Restaurant> getRestaurantsByTags(@Param("tags") String tags);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "restaurant_id, " +
                    "name, " +
                    "open_time, " +
                    "close_time, " +
                    "rating, " +
                    "address_id AS address, " +
                    "tags " +
                    "FROM restaurants rest NATURAL JOIN addresses addr " +
                    "WHERE addr.city = #{city} AND addr.street = #{street} AND addr.building = #{building}"
    )
    List<Restaurant> findByAddress(
            @Param("city") String city,
            @Param("street") String street,
            @Param("building") int building
    );

    @Select(//language=PostgreSQL
            "SELECT " +
                    "restaurant_id, " +
                    "name, " +
                    "open_time, " +
                    "close_time, " +
                    "rating, " +
                    "address_id AS address, " +
                    "tags " +
                    "FROM restaurants " +
                    "WHERE restaurant_id = #{id}")

    Restaurant findById(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE restaurants " +
                    "SET name = #{name}, " +
                    "open_time= #{openTime}, " +
                    "close_time= #{closeTime}, " +
                    "rating = #{rating}, " +
                    "address_id = #{address}, " +
                    "tags = #{tags} " +
                    "WHERE restaurant_id = #{restaurantId}"
    )
    void update(Restaurant restaurant);

    @Delete(//language=PostgreSQL
            "DELETE FROM restaurants " +
                    "WHERE restaurant_id = #{id}"
    )
    void delete(@Param("id") int id);

    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO restaurants " +
                    "(name, open_time, close_time, rating, address_id, tags)" +
                    "VALUES " +
                    "(#{name}, #{openTime}, #{closeTime}, #{rating}, #{address}, #{tags})"
    )
    @SelectKey(
            before = false,
            keyProperty = "restaurantId",
            keyColumn = "restaurant_id",
            statement = "select currval('restaurants_restaurant_id_seq')",
            resultType = Integer.class)
    void insert(Restaurant restaurant);
}
