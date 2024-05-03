package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinqiugouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinqiugouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinqiugouView;


/**
 * 商品求购
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
public interface ShangpinqiugouService extends IService<ShangpinqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinqiugouVO> selectListVO(Wrapper<ShangpinqiugouEntity> wrapper);
   	
   	ShangpinqiugouVO selectVO(@Param("ew") Wrapper<ShangpinqiugouEntity> wrapper);
   	
   	List<ShangpinqiugouView> selectListView(Wrapper<ShangpinqiugouEntity> wrapper);
   	
   	ShangpinqiugouView selectView(@Param("ew") Wrapper<ShangpinqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinqiugouEntity> wrapper);
   	
}

