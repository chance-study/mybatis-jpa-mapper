package org.chance.jpamapper.core.mapper;

import java.io.Serializable;
import java.util.Collection;

import org.chance.jpamapper.core.domain.page.Page;
import org.chance.jpamapper.core.domain.page.Pageable;
import org.chance.jpamapper.core.domain.page.Sort;

public interface PagingAndSortingMapper<T, ID extends Serializable> extends CrudMapper<T, ID> {
	/**
	 * 根据排序条件查询所有
	 * @param sort 排序条件
	 * @return 实体列表
	 */
	Collection<T> findAllSorted(Sort sort);
	
	/**
	 * 根据分页和排序条件查询所有
	 * @param pageable 分页和排序条件
	 * @return 分页实体
	 */
	Page<T> findAllPageable(Pageable pageable);
	
}
