package com.dao;

import com.entity.DiscussshangpinqiugouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangpinqiugouVO;
import com.entity.view.DiscussshangpinqiugouView;


/**
 * 商品求购评论表
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
public interface DiscussshangpinqiugouDao extends BaseMapper<DiscussshangpinqiugouEntity> {
	
	List<DiscussshangpinqiugouVO> selectListVO(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
	
	DiscussshangpinqiugouVO selectVO(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
	
	List<DiscussshangpinqiugouView> selectListView(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);

	List<DiscussshangpinqiugouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
	
	DiscussshangpinqiugouView selectView(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
	
}
