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


import com.dao.DiscussshangpinqiugouDao;
import com.entity.DiscussshangpinqiugouEntity;
import com.service.DiscussshangpinqiugouService;
import com.entity.vo.DiscussshangpinqiugouVO;
import com.entity.view.DiscussshangpinqiugouView;

@Service("discussshangpinqiugouService")
public class DiscussshangpinqiugouServiceImpl extends ServiceImpl<DiscussshangpinqiugouDao, DiscussshangpinqiugouEntity> implements DiscussshangpinqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangpinqiugouEntity> page = this.selectPage(
                new Query<DiscussshangpinqiugouEntity>(params).getPage(),
                new EntityWrapper<DiscussshangpinqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangpinqiugouEntity> wrapper) {
		  Page<DiscussshangpinqiugouView> page =new Query<DiscussshangpinqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshangpinqiugouVO> selectListVO(Wrapper<DiscussshangpinqiugouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangpinqiugouVO selectVO(Wrapper<DiscussshangpinqiugouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangpinqiugouView> selectListView(Wrapper<DiscussshangpinqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangpinqiugouView selectView(Wrapper<DiscussshangpinqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
