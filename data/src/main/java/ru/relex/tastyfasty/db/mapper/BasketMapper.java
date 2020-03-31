package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Basket;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;

import java.util.List;

@Mapper
public interface BasketMapper {
    @Select(
            "SELECT " +
                    "basket_id AS basketID, " +
                    "full_price AS fullPrice, " +
                    "number_of_persons AS numberOfPersons, " +
                    "user_id AS userID " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Basket> getBaskets(@Param("search") String search);

    @Select(
            "SELECT " +
                    "basket_id AS basketID, " +
                    "full_price AS fullPrice, " +
                    "number_of_persons AS numberOfPersons, " +
                    "user_id AS userID " +
                    "WHERE basket_id = #{id}"
    )
    Basket findByBasketId(@Param("id") int id);

    @Update(
            "UPDATE baskets " +
                    "SET " +
                    "basket_id = #{basketID}, " +
                    "full_price = #{fullPrice}, " +
                    "number_of_persons = #{numberOfPersons}, " +
                    "user_id AS userID " +
                    "WHERE basket_id = #{id}"
    )
    void update(Basket basket);

    @Delete(
            "DELETE FROM baskets " +
                    "WHERE basket_id = #{basketID}"
    )
    void delete(@Param("basketID") int basketID);

    @Insert(
            "INSERT " +
                    "INTO baskets " +
                    "(basket_id, full_price, number_of_persons, user_id)" +
                    "VALUES " +
                    "(#{basketID}, #{fullPrice}, #{numberOfPersons}, #{userID})"
    )
    void insert(Basket basket);
}
