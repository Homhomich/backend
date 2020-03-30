package ru.relex.tastyfasty.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.relex.tastyfasty.db.model.Breakfast;
import ru.relex.tastyfasty.db.model.BreakfastsInBasket;

import java.util.List;

@Mapper
public interface BreakfastsInBasketMapper {
    @Select(
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "user_ID AS userID " +
                    "WHERE #{search:VARCHAR} IS NULL "
    )
    List<Breakfast> getBreakfastsInBasket(@Param("search") String search);

    @Select("SELECT " +
            "breakfasts_in_basket_id AS breakfastsInBasketID, " +
            "basket_id AS basketID, " +
            "user_id AS userID " +
            "WHERE breakfast_in_basket_id = #{id}")
    Breakfast findByBreakfastInBasketId(@Param("id") int id);

    @Select("SELECT " +
            "breakfasts_in_basket_id AS breakfastsInBasketID, " +
            "basket_id AS basketID, " +
            "user_id AS userID " +
            "WHERE basket_id = #{id}")
    Breakfast findByBasketId(@Param("id") int id);

    @Select("SELECT " +
            "breakfasts_in_basket_id AS breakfastsInBasketID, " +
            "basket_id AS basketID, " +
            "user_id AS userID " +
            "WHERE user_id = #{id}")
    Breakfast findByUserId(@Param("id") int id);

    @Update("UPDATE breakfasts_in_basket " +
            "SET breakfasts_in_basket_id = #{breakfastsInBasketID}, " +
            "basket_id = #{basketID}, " +
            "user_id= #{userID} " +
            "WHERE order_id = #{id}")
    void update(BreakfastsInBasket breakfastsInBasket);

    @Delete("DELETE FROM breakfasts_in_basket WHERE breakfasts_basket_id = #{breakfastsInBasketID}")
    void delete(@Param("breakfastsInBasketID") int breakfastsInBasketID);

    @Insert("INSERT INTO breakfasts_in_basket ( breakfasts_in_basket_id, basket_id, user_id)" +
            "VALUES(#{breakfastsInBasketID}, #{basketID},  #{userID}")
    void insert(BreakfastsInBasket breakfastsInBasket);




}
