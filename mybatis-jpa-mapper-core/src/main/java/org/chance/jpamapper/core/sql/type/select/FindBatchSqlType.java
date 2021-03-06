package org.chance.jpamapper.core.sql.type.select;

import java.lang.reflect.Method;

import org.apache.ibatis.mapping.SqlCommandType;

import org.chance.jpamapper.core.entity.JpaModelEntity;
import org.chance.jpamapper.core.sql.helper.DefaultSqlHelper;
import org.chance.jpamapper.core.sql.type.AbstractPrecisSqlType;

public class FindBatchSqlType extends AbstractPrecisSqlType {

	public static final FindBatchSqlType INSTANCE = new FindBatchSqlType();

	@Override
	public SqlCommandType getSqlCommandType() {
		return SqlCommandType.SELECT;
	}

	@Override
	public String makeSql(JpaModelEntity jpaModelEntity, Method method) {
		final StringBuilder sql = new StringBuilder();
		sql.append("<script> ");
		sql.append(DefaultSqlHelper.selectEntitySql(jpaModelEntity));
		sql.append(DefaultSqlHelper.fromSql(jpaModelEntity));
		if (method.getParameterCount() > 0) {
			sql.append(DefaultSqlHelper.conditionIdsSql(jpaModelEntity, method));
		}
		sql.append(" </script>");
		return sql.toString().trim();
	}
}
