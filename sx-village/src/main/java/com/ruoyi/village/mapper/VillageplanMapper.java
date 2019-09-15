package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Villageplan;
import com.ruoyi.village.domain.pubObjApi;

import java.util.List;

/**
 * 美丽乡村 数据层
 * 
 * @author 张鸿权
 * @date 2019-08-20
 */
public interface VillageplanMapper 
{
	/**
     * 查询美丽乡村信息
     * 
     * @param mid 美丽乡村ID
     * @return 美丽乡村信息
     */
	public Villageplan selectVillageplanById(Integer mid);
	
	/**
     * 查询美丽乡村列表
     * 
     * @param villageplan 美丽乡村信息
     * @return 美丽乡村集合
     */
	public List<Villageplan> selectVillageplanList(Villageplan villageplan);
	
	/**
     * 新增美丽乡村
     * 
     * @param villageplan 美丽乡村信息
     * @return 结果
     */
	public int insertVillageplan(Villageplan villageplan);
	
	/**
     * 修改美丽乡村
     * 
     * @param villageplan 美丽乡村信息
     * @return 结果
     */
	public int updateVillageplan(Villageplan villageplan);
	
	/**
     * 删除美丽乡村
     * 
     * @param mid 美丽乡村ID
     * @return 结果
     */
	public int deleteVillageplanById(Integer mid);
	
	/**
     * 批量删除美丽乡村
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVillageplanByIds(String[] mids);

	public List<Villageplan> selectBeaCountryListByid(pubObjApi beavill);
	
}