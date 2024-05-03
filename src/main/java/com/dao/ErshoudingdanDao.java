package com.dao;

import com.entity.ErshoudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErshoudingdanVO;
import com.entity.view.ErshoudingdanView;


/**
 * 二手订单
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
public interface ErshoudingdanDao extends BaseMapper<ErshoudingdanEntity> {
	
	List<ErshoudingdanVO> selectListVO(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
	
	ErshoudingdanVO selectVO(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
	
	List<ErshoudingdanView> selectListView(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);

	List<ErshoudingdanView> selectListView(Pagination page,@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
	
	ErshoudingdanView selectView(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
	
}
