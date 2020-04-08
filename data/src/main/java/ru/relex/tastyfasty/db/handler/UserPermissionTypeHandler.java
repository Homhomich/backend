package ru.relex.tastyfasty.db.handler;

import org.apache.ibatis.type.MappedTypes;
import ru.relex.tastyfasty.db.model.UserPermission;

import java.util.HashSet;
import java.util.Set;

@MappedTypes(UserPermission.class)
public class UserPermissionTypeHandler extends GenericCollectionTypeHandler<Integer, UserPermission, Set<UserPermission>> {

    @Override
    protected UserPermission fromValue(Integer integer) {
        return UserPermission.of(integer).orElse(null);
    }

    @Override
    protected Set<UserPermission> newCollection() {
        return new HashSet<>();
    }
}
