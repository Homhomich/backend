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
    List<Breakfast> getBreakfastsInBasket(@Param("search") String search);*/

    /*@Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE breakfast_id = #{id}"
    )
    List<Breakfast> findByBreakfastId(@Param("id") int id);*/

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{id}"
    )
    List<Breakfast> findByBasketId(@Param("id") int id);

    @Select(//language=PostgreSQL
            "SELECT " +
                    "breakfasts_in_basket_id AS breakfastsInBasketID, " +
                    "basket_id AS basketID, " +
                    "breakfast_id AS breakfastID " +
                    "FROM breakfasts_in_basket " +
                    "WHERE breakfasts_in_basket_id = #{id}"
    )
    Breakfast findByBreakfastInBasketId(@Param("id") int id);

    @Update(//language=PostgreSQL
            "UPDATE breakfasts_in_basket " +
                    "SET breakfasts_in_basket_id = #{breakfastsInBasketID}, " +
                    "basket_id = #{basketID}, " +
                    "breakfast_id = #{breakfastID} " +
                    "WHERE breakfasts_in_basket_id = #{id}"
    )
    void update(BreakfastsInBasket breakfastsInBasket);

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE breakfasts_in_basket_id = #{breakfastsInBasketID}"
    )
    void deleteById(@Param("breakfastsInBasketID") int breakfastsInBasketID);

    @Delete(//language=PostgreSQL
            "DELETE FROM breakfasts_in_basket " +
                    "WHERE basket_id = #{basketID}"
    )
    void deleteByBasketId(@Param("basketID") int basketID);

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
