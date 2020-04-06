package ru.relex.tastyfasty.db.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.Collection;

@MappedJdbcTypes(JdbcType.ARRAY)
public abstract class GenericCollectionTypeHandler<I, T, C extends Collection<T>> implements TypeHandler<C> {

    protected abstract T fromValue(I integer);

    protected abstract C newCollection();


    @SuppressWarnings("unchecked")
    private C processArray(Array jdbcArray) throws SQLException {
        I[] array;
        try {
            array = (I[]) jdbcArray.getArray();
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Cannot cast array type to target!", e);
        }
        C collect = Arrays.stream(array)
                .map(this::fromValue)
                .collect(this::newCollection, Collection::add, Collection::addAll);
        System.err.println(collect);
        return collect;
    }

    @Override
    public void setParameter(
            PreparedStatement ps,
            int i,
            C parameter,
            JdbcType jdbcType
    ) throws SQLException {
        throw new UnsupportedOperationException("Setting array parameter not supported");
    }

    @Override
    public C getResult(ResultSet rs, String columnName) throws SQLException {
        return processArray(rs.getArray(columnName));
    }

    @Override
    public C getResult(ResultSet rs, int columnIndex) throws SQLException {
        return processArray(rs.getArray(columnIndex));
    }

    @Override
    public C getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return processArray(cs.getArray(columnIndex));
    }

}
