package ru.relex.tastyfasty.db.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import ru.relex.commons.model.Role;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Role.class)
@MappedJdbcTypes({JdbcType.INTEGER, JdbcType.BIGINT})
public class RoleTypeHandler implements TypeHandler<Role> {

    @Override
    public void setParameter(
            PreparedStatement ps,
            int i,
            Role parameter,
            JdbcType jdbcType
    ) throws SQLException {
        if (parameter != null) {
            ps.setInt(i, parameter.getId());
        } else {
            ps.setNull(i, jdbcType.TYPE_CODE);
        }
    }

    @Override
    public Role getResult(ResultSet rs, String columnName) throws SQLException {
        return Role.of(rs.getInt(columnName)).orElse(null);
    }

    @Override
    public Role getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Role.of(rs.getInt(columnIndex)).orElse(null);
    }

    @Override
    public Role getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Role.of(cs.getInt(columnIndex)).orElse(null);
    }
}
