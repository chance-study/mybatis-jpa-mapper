package org.chance.jpamapper.core.sql.dialect;

import org.chance.jpamapper.core.entity.JpaModelEntity;

public interface Dialect {
	public String getLimitSql(JpaModelEntity jpaModelEntity);
}
