package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;

import java.util.List;

@Mapper
public interface BreakfastsInBasketMapper {

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<BreakfastInBasket> getBreakfastsInBasket(@Param("search") String search);*/

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE breakfast_id = #{id}"
    )
    List<BreakfastInBasket> findByBreakfastId(@Param("id") int id);*/

    @Select(//language=PostgreSQL
            "SELECT " +
                    "bb.breakfast_id AS id, " +
                    "name, " +
                    "tag, " +
                    "price, " +
                    "restaurant_id " +
                    "FROM breakfasts_in_basket bb RIGHT JOIN breakfasts br ON bb.breakfast_id = br.breakfast_id " +
                    "WHERE bb.basket_id = #{basketId}"
    )
    List<Breakfast> findByBasketId(@Param("basketId") int basketId);

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE breakfasts_in_basket_id = #{id}"
    )
    BreakfastsInBasket findByBreakfastInBasketId(@Param("id") int id);*/

    @Update(//language=PostgreSQL
            "UPDATE breakfasts_in_basket " +
                    "SET breakfasts_in_basket_id = #{breakfastsInBasketID}, " +
                    "basket_id = #{basketID}, " +
                    "breakfast_id = #{breakfastID} " +
                    "WHERE breakfasts_in_basket_id = #{id}"
    )
    void update(BreakfastsInBasket breakfastsInBasket);

    /*@Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE breakfasts_in_basket_id = #{breakfastsInBasketID}"
    )
    void deleteById(@Param("breakfastsInBasketID") int breakfastsInBasketID);*/

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketID}"
    )
    void deleteBreakfastsByBasketId(@Param("basketID") int basketID);

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketId} AND breakfast_id = #{breakfastId}"
    )
    void deleteOneBreakfastByBasketId(@Param("basketId") int basketId, @Param("breakfastId") int breakfastId);

    @Insert(//language=PostgreSQL
            "INSERT INTO breakfasts_in_basket " +
                    "(basket_id, breakfast_id)" +
            "VALUES " +
                    "(#{basketID}, #{breakfastID})"
    )
    @SelectKey(
            before = false,
            keyProperty = "breakfastsInBasketID",
            keyColumn = "breakfasts_in_basket_id",
            statement = "select currval('breakfasts_in_basket_breakfasts_in_basket_seq')",
            resultType = Integer.class)
    void insert(BreakfastsInBasket breakfastsInBasket);




}
