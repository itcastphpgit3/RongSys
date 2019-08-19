package com.ruoyi.village.service;

import com.ruoyi.village.domain.Suggest;
import java.util.List;

/**
 * 我的建议 服务层
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
public interface ISuggestService 
{
	/**
     * 查询我的建议信息
     * 
     * @param mid 我的建议ID
     * @return 我的建议信息
     */
	public Suggest selectSuggestById(Integer mid);
	
	/**
     * 查询我的建议列表
     * 
     * @param suggest 我的建议信息
     * @return 我的建议集合
     */
	public List<Suggest> selectSuggestList(Suggest suggest);
	
	/**
     * 新增我的建议
     * 
     * @param suggest 我的建议信息
     * @return 结果
     */
	public int insertSuggest(Suggest suggest);
	
	/**
     * 修改我的建议
     * 
     * @param suggest 我的建议信息
     * @return 结果
     */
	public int updateSuggest(Suggest suggest);
		
	/**
     * 删除我的建议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSuggestByIds(String ids);
	
}
