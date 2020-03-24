package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Address;

public interface AddressMapper {
    @Select("SELECT " +
            "address_id AS id," +
            "city, " +
            "street, " +
            "building, " +
            "FROM addresses" +
            "WHERE addresses_id = #{id}")
    Address getAddressById(@Param("id") int id);

    @Update("UPDATE addresses " +
            "SET city = #{city}," +
            "street = #{street}," +
            "building = #{building}," +
            "address_id = #{id}," +
            "WHERE address_id = #{id}")
    void update(Address address);

    @Delete("DELETE FROM addresses WHERE id = #{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO addresses (city, street, building) " +
            "VALUES(#{firstName}, #{city}, #{street}, #{building})")
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "address_id",
            statement = "select currval('addresses_address_id_seq')",
            resultType = Integer.class)
    void insert(Address address);
}
