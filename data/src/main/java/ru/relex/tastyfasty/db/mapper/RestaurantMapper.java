package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Restaurant;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    @Select(
            "SELECT " +
                    "restaurant_id," +
                    "name,"  +
                    "rating," +
                    "address_id," +
                    "tags" +
                    "FROM restaurants rest " +
                    "WHERE #{search:VARCHAR} IS NULL " +
                    "OR CONCAT_WS('$', name, rating, tags) LIKE CONCAT('%', #{search:VARCHAR}, '%')"
    )
    List<Restaurant> getRestaurants(@Param("search") String search);

    @Select("SELECT " +
            "restaurant_id AS id," +
            "name," +
            "open_time," +
            "close_time," +
            "rating," +
            "address_id," +
            "tags" +
            "FROM restaurants rest " +
            "WHERE restaurant_id = #{id}")
    Restaurant findById(@Param("id") int id);

    @Select("SELECT " +
            "restaurant_id AS id," +
            "name," +
            "open_time," +
            "close_time," +
            "rating," +
            "address_id," +
            "tags" +
            "FROM addresses addr " +
            "WHERE addr.city = #{city} AND addr.street = #{street} AND addr.building = #{building}")
    Restaurant findByAddress(@Param("city") String city, @Param("street") String street, @Param("building") int building);


    @Update("UPDATE restaurants " +
            "SET name = #{name}," +
            "open_time= #{open_time}," +
            "close_time= #{close_time}," +
            "rating = #{rating}," +
            "address_id = #{address_id} " +
            "tags = #{tags} " +
            "WHERE restaurant_id = #{id}")
    void update(Restaurant restaurant);

    @Delete("DELETE FROM restaurants WHERE restaurant_id = #{restaurant_id}")
    void delete(@Param("restaurant_id") int restaurant_id);


    @Insert("INSERT INTO restaurants ( restaurant_id, name, open_time, close_time,  rating, address_id, tags)" +
            "VALUES(#{restaurant_id}, #{name},  #{open_time}, #{close_time}, #{rating}, #{address_id}, #{tags})")
    void insert(Restaurant restaurant);
}
