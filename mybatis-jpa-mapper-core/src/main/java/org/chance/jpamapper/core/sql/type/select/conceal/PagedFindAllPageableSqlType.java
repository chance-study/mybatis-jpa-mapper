package org.chance.jpamapper.core.sql.type.select.conceal;

import org.apache.ibatis.mapping.SqlCommandType;

import org.chance.jpamapper.core.entity.JpaModelEntity;
import org.chance.jpamapper.core.sql.helper.PageAndSortSqlHelper;
import org.chance.jpamapper.core.sql.type.AbstractConcealedSqlType;

public class PagedFindAllPageableSqlType extends AbstractConcealedSqlType {

	public static final PagedFindAllPageableSqlType INSTANCE = new PagedFindAllPageableSqlType();

	@Override
	public SqlCommandType getSqlCommandType() {
		return SqlCommandType.SELECT;
	}

	@Override
	public String makeConcealedSql(JpaModelEntity jpaModelEntity) {
		return PageAndSortSqlHelper.limitForAllSql(jpaModelEntity);
	}
}
