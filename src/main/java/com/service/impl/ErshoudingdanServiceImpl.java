package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ErshoudingdanDao;
import com.entity.ErshoudingdanEntity;
import com.service.ErshoudingdanService;
import com.entity.vo.ErshoudingdanVO;
import com.entity.view.ErshoudingdanView;

@Service("ershoudingdanService")
public class ErshoudingdanServiceImpl extends ServiceImpl<ErshoudingdanDao, ErshoudingdanEntity> implements ErshoudingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErshoudingdanEntity> page = this.selectPage(
                new Query<ErshoudingdanEntity>(params).getPage(),
                new EntityWrapper<ErshoudingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ErshoudingdanEntity> wrapper) {
		  Page<ErshoudingdanView> page =new Query<ErshoudingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ErshoudingdanVO> selectListVO(Wrapper<ErshoudingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ErshoudingdanVO selectVO(Wrapper<ErshoudingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ErshoudingdanView> selectListView(Wrapper<ErshoudingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ErshoudingdanView selectView(Wrapper<ErshoudingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
