package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Yuqing;
import com.ruoyi.village.mapper.YuqingMapper;
import com.ruoyi.village.service.IYuqingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 舆情上报 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-08-18
 */
@Service
public class YuqingServiceImpl implements IYuqingService 
{
	@Autowired
	private YuqingMapper yuqingMapper;

	/**
     * 查询舆情上报信息
     * 
     * @param yqid 舆情上报ID
     * @return 舆情上报信息
     */
    @Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public Yuqing selectYuqingById(Integer yqid)
	{
	    return yuqingMapper.selectYuqingById(yqid);
	}
	
	/**
     * 查询舆情上报列表
     * 
     * @param yuqing 舆情上报信息
     * @return 舆情上报集合
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Yuqing> selectYuqingList(Yuqing yuqing)
	{
	    return yuqingMapper.selectYuqingList(yuqing);
	}
	
    /**
     * 新增舆情上报
     * 
     * @param yuqing 舆情上报信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int insertYuqing(Yuqing yuqing)
	{
	    return yuqingMapper.insertYuqing(yuqing);
	}
	
	/**
     * 修改舆情上报
     * 
     * @param yuqing 舆情上报信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int updateYuqing(Yuqing yuqing)
	{
	    return yuqingMapper.updateYuqing(yuqing);
	}

	/**
     * 删除舆情上报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int deleteYuqingByIds(String ids)
	{
		return yuqingMapper.deleteYuqingByIds(Convert.toStrArray(ids));
	}
	
}
