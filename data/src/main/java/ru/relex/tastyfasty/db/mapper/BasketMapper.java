package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Basket;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;

import java.util.List;

@Mapper
public interface BasketMapper {

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "basket_id AS basketID, " +
                    "full_price AS fullPrice, " +
                    "number_of_persons AS numberOfPersons, " +
                    "user_id AS userID " +
                    "FROM baskets " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Basket> getBaskets(@Param("search") String search);*/

    @Select(//language=PostgreSQL
            "SELECT " +
                    "basket_id AS basketID, " +
                    "full_price AS fullPrice, " +
                    "number_of_persons AS numberOfPersons, " +
                    "user_id AS userID " +
                    "FROM baskets " +
                    "WHERE user_id = #{id}"
    )
    Basket findByUserId(@Param("id") int id);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "basket_id AS basketID, " +
                    "full_price AS fullPrice, " +
                    "number_of_persons AS numberOfPersons, " +
                    "user_id AS userID " +
                    "FROM baskets " +
                    "WHERE basket_id = #{id}"
    )
    Basket findByBasketId(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE baskets " +
                    "SET " +
                    "basket_id = #{basketID}, " +
                    "full_price = #{fullPrice}, " +
                    "number_of_persons = #{numberOfPersons}, " +
                    "user_id = #{userID} " +
                    "WHERE basket_id = #{basketID}"
    )
    void update(Basket basket);

    @Delete(//language=PostgreSQL
            "DELETE FROM baskets " +
                    "WHERE basket_id = #{basketId}"
    )
    void deleteByBasketId(@Param("basketId") int basketId);

    @Delete(//language=PostgreSQL
            "DELETE FROM baskets " +
                    "WHERE user_id = #{userId}"
    )
    void deleteByUserId(@Param("userId") int userId);

    @Insert(//language=PostgreSQL
            "INSERT " +
                    "INTO baskets " +
                    "(full_price, number_of_persons, user_id)" +
                    "VALUES " +
                    "(#{fullPrice}, #{numberOfPersons}, #{userID})"
    )
    @SelectKey(
            before = false,
            keyProperty = "basketID",
            keyColumn = "basket_id",
            statement = "select currval('baskets_basket_id_seq')",
            resultType = Integer.class)
    void insert(Basket basket);
}
