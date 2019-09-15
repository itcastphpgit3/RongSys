package com.ruoyi.village.service;

import com.ruoyi.village.domain.Memorial;
import com.ruoyi.village.domain.pubObjApi;

import java.util.List;

/**
 * 备忘录 服务层
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
public interface IMemorialService 
{
	/**
     * 查询备忘录信息
     * 
     * @param mid 备忘录ID
     * @return 备忘录信息
     */
	public Memorial selectMemorialById(Integer mid);
	
	/**
     * 查询备忘录列表
     * 
     * @param memorial 备忘录信息
     * @return 备忘录集合
     */
	public List<Memorial> selectMemorialList(Memorial memorial);
	
	/**
     * 新增备忘录
     * 
     * @param memorial 备忘录信息
     * @return 结果
     */
	public int insertMemorial(Memorial memorial);
	
	/**
     * 修改备忘录
     * 
     * @param memorial 备忘录信息
     * @return 结果
     */
	public int updateMemorial(Memorial memorial);
		
	/**
     * 删除备忘录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemorialByIds(String ids);

	public List<Memorial> selectMemorialListById(pubObjApi memorial);
}
