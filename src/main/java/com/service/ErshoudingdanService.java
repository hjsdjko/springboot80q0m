package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ErshoudingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ErshoudingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ErshoudingdanView;


/**
 * 二手订单
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
public interface ErshoudingdanService extends IService<ErshoudingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ErshoudingdanVO> selectListVO(Wrapper<ErshoudingdanEntity> wrapper);
   	
   	ErshoudingdanVO selectVO(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
   	
   	List<ErshoudingdanView> selectListView(Wrapper<ErshoudingdanEntity> wrapper);
   	
   	ErshoudingdanView selectView(@Param("ew") Wrapper<ErshoudingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ErshoudingdanEntity> wrapper);
   	
}

