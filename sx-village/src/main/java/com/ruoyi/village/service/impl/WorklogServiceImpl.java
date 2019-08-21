package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Worklog;
import com.ruoyi.village.mapper.WorklogMapper;
import com.ruoyi.village.service.IWorklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 工作记录 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-07-23
 */
@Service
public class WorklogServiceImpl implements IWorklogService 
{
	@Autowired
	private WorklogMapper worklogMapper;

	/**
     * 查询工作记录信息
     * 
     * @param wid 工作记录ID
     * @return 工作记录信息
     */
    @Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public Worklog selectWorklogById(Integer wid)
	{
	    return worklogMapper.selectWorklogById(wid);
	}

	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public  List<HashMap>selectWorkLogByProId(Integer proid)
	{
		return worklogMapper.selectWorkLogByProId(proid);
	}

	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int selectWorkLogNumByProId(Integer proid)
	{
		return worklogMapper.selectWorkLogNumByProId(proid);
	}

	/**
     * 查询工作记录列表
     * 
     * @param worklog 工作记录信息
     * @return 工作记录集合
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Worklog> selectWorklogList(Worklog worklog)
	{
	    return worklogMapper.selectWorklogList(worklog);
	}
	
    /**
     * 新增工作记录
     * 
     * @param worklog 工作记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int insertWorklog(Worklog worklog)
	{
	    return worklogMapper.insertWorklog(worklog);
	}
	
	/**
     * 修改工作记录
     * 
     * @param worklog 工作记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int updateWorklog(Worklog worklog)
	{
	    return worklogMapper.updateWorklog(worklog);
	}

	/**
     * 删除工作记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int deleteWorklogByIds(String ids)
	{
		return worklogMapper.deleteWorklogByIds(Convert.toStrArray(ids));
	}
	
}
