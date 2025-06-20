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


import com.dao.FuwujiedanDao;
import com.entity.FuwujiedanEntity;
import com.service.FuwujiedanService;
import com.entity.vo.FuwujiedanVO;
import com.entity.view.FuwujiedanView;

@Service("fuwujiedanService")
public class FuwujiedanServiceImpl extends ServiceImpl<FuwujiedanDao, FuwujiedanEntity> implements FuwujiedanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwujiedanEntity> page = this.selectPage(
                new Query<FuwujiedanEntity>(params).getPage(),
                new EntityWrapper<FuwujiedanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwujiedanEntity> wrapper) {
		  Page<FuwujiedanView> page =new Query<FuwujiedanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FuwujiedanVO> selectListVO(Wrapper<FuwujiedanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwujiedanVO selectVO(Wrapper<FuwujiedanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwujiedanView> selectListView(Wrapper<FuwujiedanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwujiedanView selectView(Wrapper<FuwujiedanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
