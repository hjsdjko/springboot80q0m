package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangpinqiugouEntity;
import com.entity.view.ShangpinqiugouView;

import com.service.ShangpinqiugouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 商品求购
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:46:58
 */
@RestController
@RequestMapping("/shangpinqiugou")
public class ShangpinqiugouController {
    @Autowired
    private ShangpinqiugouService shangpinqiugouService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinqiugouEntity shangpinqiugou, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shangpinqiugou.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangpinqiugouEntity> ew = new EntityWrapper<ShangpinqiugouEntity>();
		PageUtils page = shangpinqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinqiugou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinqiugouEntity shangpinqiugou, HttpServletRequest request){
        EntityWrapper<ShangpinqiugouEntity> ew = new EntityWrapper<ShangpinqiugouEntity>();
		PageUtils page = shangpinqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinqiugou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinqiugouEntity shangpinqiugou){
       	EntityWrapper<ShangpinqiugouEntity> ew = new EntityWrapper<ShangpinqiugouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinqiugou, "shangpinqiugou")); 
        return R.ok().put("data", shangpinqiugouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinqiugouEntity shangpinqiugou){
        EntityWrapper< ShangpinqiugouEntity> ew = new EntityWrapper< ShangpinqiugouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinqiugou, "shangpinqiugou")); 
		ShangpinqiugouView shangpinqiugouView =  shangpinqiugouService.selectView(ew);
		return R.ok("查询商品求购成功").put("data", shangpinqiugouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinqiugouEntity shangpinqiugou = shangpinqiugouService.selectById(id);
        return R.ok().put("data", shangpinqiugou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinqiugouEntity shangpinqiugou = shangpinqiugouService.selectById(id);
        return R.ok().put("data", shangpinqiugou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinqiugouEntity shangpinqiugou, HttpServletRequest request){
    	shangpinqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinqiugou);
        shangpinqiugouService.insert(shangpinqiugou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinqiugouEntity shangpinqiugou, HttpServletRequest request){
    	shangpinqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinqiugou);
        shangpinqiugouService.insert(shangpinqiugou);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinqiugouEntity shangpinqiugou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinqiugou);
        shangpinqiugouService.updateById(shangpinqiugou);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinqiugouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShangpinqiugouEntity> wrapper = new EntityWrapper<ShangpinqiugouEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = shangpinqiugouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
