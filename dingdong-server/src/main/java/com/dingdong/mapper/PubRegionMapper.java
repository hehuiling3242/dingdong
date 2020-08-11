package com.dingdong.mapper;

import java.util.List;

import com.dingdong.domain.model.PubRegion;
import com.dingdong.domain.query.PubRegionQuery;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

public interface PubRegionMapper  {
	/***/
	PubRegion load(String id);

	/***/
	void insert(PubRegion pubRegion);

	/***/
	void update(PubRegion pubRegion);

	/***/
	void updateStatus(@Param("id") String id, @Param("status") Serializable status);

    /***/
    void updateIsDeleted(@Param("id") String id, @Param("isDeleted") int status);

	/***/
	void delete(String id);

	/***/
	List<PubRegion> queryList(PubRegionQuery pubRegionQuery);

	/***/
	int queryCount(PubRegionQuery pubRegionQuery);
}