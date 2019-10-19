package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.domain.TerminalTels;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 终端地域 数据层
 *
 * @author cx
 * @date 2019-02-17
 */
public interface OrganizationMapper
{
	/**
	 * 查询终端地域信息
	 *
	 *
	 * @return 终端地域信息
	 */
	public Organization selectAllOrganization();
	/**
	 * 查询终端地域信息
	 *
	 * @param tid 设备IMEI
	 * @return 终端地域信息
	 */
	public Organization selectOrganizationByTid(String tid);

	/**
	 * 查询终端地域列表
	 *
	 * @param organization 终端地域信息
	 * @return 终端地域集合
	 */
	public List<Organization> selectOrganizationList(Organization organization);

	/**
	 * 终端管理显示页面
	 *
	 * @param organization
	 * @return 终端管理页面集合
	 */
	public List<Organization> selectOrganizationList1(Organization organization);

	/**
	 * 新增终端地域
	 *
	 * @param organization 终端地域信息
	 * @return 结果
	 */
	public int insertOrganization(Organization organization);


	public int insertOrganizationCon(Organization organization);
	/**
	 * 新增终端地址图片
	 *
	 * @param organization 终端地域信息
	 * @return 结果
	 */
	public int insertOrganizationPic(Organization organization);

//	/**
//	 * 修改终端地域
//	 *
//	 * @param organization 终端地域信息
//	 * @return 结果
//	 */
//	public int updateOrganization(Organization organization);

	/**
	 * 删除终端地域
	 *
	 * @param tid 终端地域ID
	 * @return 结果
	 */
	public int deleteOrganizationById(String tid);

	/**
	 * 批量删除终端地域
	 *
	 * @param tids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteOrganizationByIds(String[] tids);

	/**
	 * 查询节目单终端列表
	 *
	 * @param organization 终端信息
	 * @return 终端集合
	 */
	public List<Organization> selectProBroadList(Organization organization);

	/**
	 *
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 * @throws Exception 异常
	 */
	public int addProIdAll(Long[] ids);

	/**
	 *  设置终端的RDS码
	 *
	 * @param ids 需要修改终端的RDS码
	 * @return 结果
	 */
	public int updateRdsByIds(@Param("ids") String[] ids, @Param("number")String number);

	/**
	 *  设置终端的频率码
	 *
	 * @param ids 需要修改终端的RDS码
	 * @return 结果
	 */
	public int updateFmfrequencyByIds(@Param("ids") String[] ids, @Param("number")String number);

	public int updateIsuseByTid(@Param("tid") String tid, @Param("isuse")Boolean isuse);

	/**
	 * 获取到下面所有的 aid
	 * @param aid
	 * @return
	 */
	public  List<String> listNextAid(String aid);

	//	通过 aid 查询所有终端
	public List<Organization> listOrgByAid(@Param("list")List<String> aid);

	//	通过 tid 查询对应终端的RDS码
	public Organization selectRdsByTid(String tid);
	/**
	 * 通过IMEI获取终端维护员电话
	 * @param tid
	 * @return
	 */
	public  List<TerminalTels> selectTelsByTid(String tid);

	/**
	 * @author cx
	 * @param organization
	 *
	 * @Description 更新终端数据
	 */
	public int updateOrganization(Organization organization);

	/**
	 * @author cx
	 * @param organization
	 *
	 * @Description 更新终端所属用户
	 */
	public int updateUsername(Organization organization);

	/**
	 * 根据条件分页查询终端对象
	 *
	 * @param organization 导出终端字段
	 * @return 终端信息集合信息
	 */
	public List<Organization> exportOrganization(Organization organization);

	public  List<Area> listNextAidName(String aid);

}