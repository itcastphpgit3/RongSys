package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Partystudy;
import com.ruoyi.village.domain.pubObjApi;

import java.util.List;

/**
 * 党员学习 数据层
 * 
 * @author 张鸿权
 * @date 2019-08-25
 */
public interface


PartystudyMapper
{
	/**
     * 查询党员学习信息
     * 
     * @param mid 党员学习ID
     * @return 党员学习信息
     */
	public Partystudy selectPartystudyById(Integer mid);
	
	/**
     * 查询党员学习列表
     * 
     * @param partystudy 党员学习信息
     * @return 党员学习集合
     */
	public List<Partystudy> selectPartystudyList(Partystudy partystudy);
	
	/**
     * 新增党员学习
     * 
     * @param partystudy 党员学习信息
     * @return 结果
     */
	public int insertPartystudy(Partystudy partystudy);
	
	/**
     * 修改党员学习
     * 
     * @param partystudy 党员学习信息
     * @return 结果
     */
	public int updatePartystudy(Partystudy partystudy);
	
	/**
     * 删除党员学习
     * 
     * @param mid 党员学习ID
     * @return 结果
     */
	public int deletePartystudyById(Integer mid);
	
	/**
     * 批量删除党员学习
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deletePartystudyByIds(String[] mids);

	public List<Partystudy> selectPartystudyListById(pubObjApi partystudy);
}