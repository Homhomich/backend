package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.db.model.BasketItem;

import java.util.List;

@Mapper
public interface BasketItemMapper {

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
    List<Breakfast> findBreakfastsByBasketId(@Param("basketId") int basketId);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS basketItemID, " +
                    "basket_id, " +
                    "breakfast_id, " +
                    "num_of_items AS numberOfItems, " +
                    "ready_to_order " +
                    "FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketId}"
    )
    List<BasketItem> findBasketItemsByBasketId(@Param("basketId") int basketId);

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
                    "SET breakfasts_in_basket_id = #{basketItemID}, " +
                    "basket_id = #{basketID}, " +
                    "breakfast_id = #{breakfastID}, " +
                    "num_of_items = #{numberOfItems}, " +
                    "ready_to_order = #{readyToOrder} " +
                    "WHERE breakfasts_in_basket_id = #{basketItemID}"
    )
    void update(BasketItem basketItem);

    /*@Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE breakfasts_in_basket_id = #{basketItemID}"
    )
    void deleteById(@Param("basketItemID") int basketItemID);*/

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketId}"
    )
    void deleteBreakfastsByBasketId(@Param("basketId") int basketId);

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketId} AND breakfast_id = #{breakfastId}"
    )
    void deleteOneBreakfastByBasketId(@Param("basketId") int basketId, @Param("breakfastId") int breakfastId);

    @Insert(//language=PostgreSQL
            "INSERT INTO breakfasts_in_basket " +
                    "(basket_id, breakfast_id, num_of_items, ready_to_order)" +
            "VALUES " +
                    "(#{basketID}, #{breakfastID}, #{numberOfItems}, #{readyToOrder})"
    )
    @SelectKey(
            before = false,
            keyProperty = "basketItemID",
            keyColumn = "breakfasts_in_basket_id",
            statement = "select currval('breakfasts_in_basket_breakfasts_in_basket_seq')",
            resultType = Integer.class)
    void insert(BasketItem basketItem);




}
