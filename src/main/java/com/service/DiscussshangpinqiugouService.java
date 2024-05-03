package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshangpinqiugouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshangpinqiugouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshangpinqiugouView;


/**
 * 商品求购评论表
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
public interface DiscussshangpinqiugouService extends IService<DiscussshangpinqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshangpinqiugouVO> selectListVO(Wrapper<DiscussshangpinqiugouEntity> wrapper);
   	
   	DiscussshangpinqiugouVO selectVO(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
   	
   	List<DiscussshangpinqiugouView> selectListView(Wrapper<DiscussshangpinqiugouEntity> wrapper);
   	
   	DiscussshangpinqiugouView selectView(@Param("ew") Wrapper<DiscussshangpinqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshangpinqiugouEntity> wrapper);
   	
}

