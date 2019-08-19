package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Company;

import java.util.List;

/**
 * 企业 数据层
 * 
 * @author 张鸿权
 * @date 2019-08-08
 */
public interface CompanyMapper 
{
	/**
     * 查询企业信息
     * 
     * @param cid 企业ID
     * @return 企业信息
     */
	public Company selectCompanyById(Integer cid);
	
	/**
     * 查询企业列表
     * 
     * @param company 企业信息
     * @return 企业集合
     */
	public List<Company> selectCompanyList(Company company);
	
	/**
     * 新增企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	public int insertCompany(Company company);
	
	/**
     * 修改企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	public int updateCompany(Company company);
	
	/**
     * 删除企业
     * 
     * @param cid 企业ID
     * @return 结果
     */
	public int deleteCompanyById(Integer cid);
	
	/**
     * 批量删除企业
     * 
     * @param cids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyByIds(String[] cids);
	
}