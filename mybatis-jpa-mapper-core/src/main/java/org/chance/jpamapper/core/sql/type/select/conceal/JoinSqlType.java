package org.chance.jpamapper.core.sql.type.select.conceal;

import org.apache.ibatis.mapping.SqlCommandType;

import org.chance.jpamapper.core.entity.JoinEntity;
import org.chance.jpamapper.core.entity.JpaModelEntity;
import org.chance.jpamapper.core.sql.helper.DefaultSqlHelper;
import org.chance.jpamapper.core.sql.type.AbstractConcealedSqlType;

/**
 * 联表的隐性SqlType
 * @author fufei
 *
 */
public class JoinSqlType extends AbstractConcealedSqlType {

	public static final JoinSqlType INSTANCE = new JoinSqlType();

	@Override
	public SqlCommandType getSqlCommandType() {
		return SqlCommandType.SELECT;
	}

	@Override
	public String makeConcealedSql(JpaModelEntity jpaModelEntity) {
		final StringBuilder sql = new StringBuilder();
		sql.append("<script> ");
		sql.append(DefaultSqlHelper.selectEntitySql(jpaModelEntity));
		sql.append(DefaultSqlHelper.fromSql(jpaModelEntity));
		
		JoinEntity joinEntity = jpaModelEntity.getJoinEntity();
		
		sql.append(DefaultSqlHelper.conditionConcealBySql(jpaModelEntity, joinEntity.getJoinColumns()));
		sql.append(" </script>");
		return sql.toString().trim();
	}
}
