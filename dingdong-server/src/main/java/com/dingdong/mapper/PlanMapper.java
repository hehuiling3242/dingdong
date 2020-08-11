package com.dingdong.mapper;

import java.util.List;

import com.dingdong.domain.model.Plan;
import com.dingdong.domain.query.PlanQuery;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

public interface PlanMapper  {
	/***/
	Plan load(Long id);

	/***/
	void insert(Plan plan);

	/***/
	void update(Plan plan);

	/***/
	void updateStatus(@Param("id") Long id, @Param("status") Serializable status);

    /***/
    void updateIsDeleted(@Param("id") Long id, @Param("isDeleted") int status);

	/***/
	void delete(Long id);

	/***/
	List<Plan> queryList(PlanQuery planQuery);

	/***/
	int queryCount(PlanQuery planQuery);
}