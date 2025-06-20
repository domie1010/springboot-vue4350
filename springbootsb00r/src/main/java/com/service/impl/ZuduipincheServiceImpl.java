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


import com.dao.ZuduipincheDao;
import com.entity.ZuduipincheEntity;
import com.service.ZuduipincheService;
import com.entity.vo.ZuduipincheVO;
import com.entity.view.ZuduipincheView;

@Service("zuduipincheService")
public class ZuduipincheServiceImpl extends ServiceImpl<ZuduipincheDao, ZuduipincheEntity> implements ZuduipincheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuduipincheEntity> page = this.selectPage(
                new Query<ZuduipincheEntity>(params).getPage(),
                new EntityWrapper<ZuduipincheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuduipincheEntity> wrapper) {
		  Page<ZuduipincheView> page =new Query<ZuduipincheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuduipincheVO> selectListVO(Wrapper<ZuduipincheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuduipincheVO selectVO(Wrapper<ZuduipincheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuduipincheView> selectListView(Wrapper<ZuduipincheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuduipincheView selectView(Wrapper<ZuduipincheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
