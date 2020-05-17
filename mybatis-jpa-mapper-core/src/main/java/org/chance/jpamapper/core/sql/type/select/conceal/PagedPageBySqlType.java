package org.chance.jpamapper.core.sql.type.select.conceal;

import org.apache.ibatis.mapping.SqlCommandType;

import org.chance.jpamapper.core.entity.JpaModelEntity;
import org.chance.jpamapper.core.sql.helper.PageAndSortSqlHelper;
import org.chance.jpamapper.core.sql.type.AbstractConcealedSqlType;

public class PagedPageBySqlType extends AbstractConcealedSqlType {

	public static final PagedPageBySqlType INSTANCE = new PagedPageBySqlType();

	@Override
	public SqlCommandType getSqlCommandType() {
		return SqlCommandType.SELECT;
	}

	@Override
	public String makeConcealedSql(JpaModelEntity jpaModelEntity) {
		return PageAndSortSqlHelper.limitForAllSql(jpaModelEntity);
	}
}
