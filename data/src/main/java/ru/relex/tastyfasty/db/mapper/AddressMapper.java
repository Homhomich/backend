package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Address;

import java.util.List;

public interface AddressMapper {

    @Select(//language=PostgreSQL
            "SELECT " +
                    "address_id AS id, " +
                    "city, " +
                    "street, " +
                    "building " +
                    "FROM addresses " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Address> getAddresses(@Param("search") String search);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "address_id AS id, " +
                    "city, " +
                    "street, " +
                    "building " +
                    "FROM addresses " +
                    "WHERE address_id = #{id}"
    )
    Address getAddressById(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE addresses " +
                    "SET city = #{city}, " +
                    "street = #{street}, " +
                    "building = #{building}, " +
                    "address_id = #{id} " +
                    "WHERE address_id = #{id}"
    )
    void update(Address address);

    @Delete(//language=PostgreSQL
            "DELETE FROM addresses " +
                    "WHERE address_id = #{id}"
    )
    void delete(@Param("id") int id);

    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO addresses " +
                    "(city, street, building) " +
                    "VALUES " +
                    "(#{city}, #{street}, #{building})"
    )
    @SelectKey(
            before = false,
            keyProperty = "id",
            keyColumn = "address_id",
            statement = "select currval('addresses_address_id_seq')",
            resultType = Integer.class)
    void insert(Address address);
}
