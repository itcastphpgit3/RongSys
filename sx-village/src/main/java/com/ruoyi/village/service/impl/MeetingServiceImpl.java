package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Meeting;
import com.ruoyi.village.mapper.MeetingMapper;
import com.ruoyi.village.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会议记录 服务层实现
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
@Service
public class MeetingServiceImpl implements IMeetingService 
{
	@Autowired
	private MeetingMapper meetingMapper;

	/**
     * 查询会议记录信息
     * 
     * @param mid 会议记录ID
     * @return 会议记录信息
     */
    @Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public Meeting selectMeetingById(Integer mid)
	{
	    return meetingMapper.selectMeetingById(mid);
	}
	
	/**
     * 查询会议记录列表
     * 
     * @param meeting 会议记录信息
     * @return 会议记录集合
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public List<Meeting> selectMeetingList(Meeting meeting)
	{
	    return meetingMapper.selectMeetingList(meeting);
	}
	
    /**
     * 新增会议记录
     * 
     * @param meeting 会议记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int insertMeeting(Meeting meeting)
	{
	    return meetingMapper.insertMeeting(meeting);
	}
	
	/**
     * 修改会议记录
     * 
     * @param meeting 会议记录信息
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int updateMeeting(Meeting meeting)
	{
	    return meetingMapper.updateMeeting(meeting);
	}

	/**
     * 删除会议记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@DataSource(value = DataSourceType.SXVILLAGE)
	public int deleteMeetingByIds(String ids)
	{
		return meetingMapper.deleteMeetingByIds(Convert.toStrArray(ids));
	}
	
}
