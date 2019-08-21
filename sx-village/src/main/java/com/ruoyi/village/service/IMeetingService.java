package com.ruoyi.village.service;

import com.ruoyi.village.domain.Meeting;
import java.util.List;

/**
 * 会议记录 服务层
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
public interface IMeetingService 
{
	/**
     * 查询会议记录信息
     * 
     * @param mid 会议记录ID
     * @return 会议记录信息
     */
	public Meeting selectMeetingById(Integer mid);
	
	/**
     * 查询会议记录列表
     * 
     * @param meeting 会议记录信息
     * @return 会议记录集合
     */
	public List<Meeting> selectMeetingList(Meeting meeting);
	
	/**
     * 新增会议记录
     * 
     * @param meeting 会议记录信息
     * @return 结果
     */
	public int insertMeeting(Meeting meeting);
	
	/**
     * 修改会议记录
     * 
     * @param meeting 会议记录信息
     * @return 结果
     */
	public int updateMeeting(Meeting meeting);
		
	/**
     * 删除会议记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMeetingByIds(String ids);
	
}
