package com.ruoyi.village.service;

import com.ruoyi.village.domain.Mcount;
import com.ruoyi.village.domain.PersonApi;
import com.ruoyi.village.domain.VillagerInfo;
import java.util.List;

/**
 * 村民 服务层
 * 
 * @author zx
 * @date 2019-09-21
 */
public interface IVillagerInfoService 
{
	/**
	 * 查询村民信息
	 *
	 * @param vid 村民ID
	 * @return 村民信息
	 */
	public VillagerInfo selectVillagerInfoById(Integer vid);

	/**
	 * 查询村民列表
	 *
	 * @param villagerInfo 村民信息
	 * @return 村民集合
	 */
	public List<VillagerInfo> selectVillagerInfoList(VillagerInfo villagerInfo);

	/**
	 * 新增村民
	 *
	 * @param villagerInfo 村民信息
	 * @return 结果
	 */
	public int insertVillagerInfo(VillagerInfo villagerInfo);

	/**
	 * 修改村民
	 *
	 * @param villagerInfo 村民信息
	 * @return 结果
	 */
	public int updateVillagerInfo(VillagerInfo villagerInfo);

	/**
	 * 删除村民信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteVillagerInfoByIds(String ids);

	public List<VillagerInfo> selectPersonAllByApi(PersonApi person);

	public Mcount countpmBySex(PersonApi person);

	public List<VillagerInfo> selectvillagerInfoListBytype(PersonApi person);
	public List<VillagerInfo> selectGrouplist(PersonApi person);

}
