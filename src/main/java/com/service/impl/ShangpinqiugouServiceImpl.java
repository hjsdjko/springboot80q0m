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


import com.dao.ShangpinqiugouDao;
import com.entity.ShangpinqiugouEntity;
import com.service.ShangpinqiugouService;
import com.entity.vo.ShangpinqiugouVO;
import com.entity.view.ShangpinqiugouView;

@Service("shangpinqiugouService")
public class ShangpinqiugouServiceImpl extends ServiceImpl<ShangpinqiugouDao, ShangpinqiugouEntity> implements ShangpinqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinqiugouEntity> page = this.selectPage(
                new Query<ShangpinqiugouEntity>(params).getPage(),
                new EntityWrapper<ShangpinqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinqiugouEntity> wrapper) {
		  Page<ShangpinqiugouView> page =new Query<ShangpinqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpinqiugouVO> selectListVO(Wrapper<ShangpinqiugouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpinqiugouVO selectVO(Wrapper<ShangpinqiugouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpinqiugouView> selectListView(Wrapper<ShangpinqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpinqiugouView selectView(Wrapper<ShangpinqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
