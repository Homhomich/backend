package ru.relex.tastyfasty.db.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import ru.relex.tastyfasty.db.model.UserPermission;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(UserPermission.class)
@MappedJdbcTypes({JdbcType.INTEGER, JdbcType.BIGINT})
public class UserPermissionTypeHandler implements TypeHandler<UserPermission> {

    @Override
    public void setParameter(
            PreparedStatement ps,
            int i, UserPermission parameter,
            JdbcType jdbcType
    ) throws SQLException {
        if (parameter != null) {
            ps.setInt(i, parameter.getId());
        } else {
            ps.setNull(i, jdbcType.TYPE_CODE);
        }
    }

    @Override
    public UserPermission getResult(ResultSet rs, String columnName) throws SQLException {
        return UserPermission.of(rs.getInt(columnName)).orElse(null);
    }

    @Override
    public UserPermission getResult(ResultSet rs, int columnIndex) throws SQLException {
        return UserPermission.of(rs.getInt(columnIndex)).orElse(null);
    }

    @Override
    public UserPermission getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return UserPermission.of(cs.getInt(columnIndex)).orElse(null);
    }
}
