package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Company;
import com.ruoyi.village.service.ICompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 企业 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/village/company")
public class CompanyController extends BaseController
{
    private String prefix = "village/company";
	
	@Autowired
	private ICompanyService companyService;
	
	@RequiresPermissions("village:company:view")
	@GetMapping()
	public String company()
	{
	    return prefix + "/company";
	}
	
	/**
	 * 查询企业列表
	 */
	@RequiresPermissions("village:company:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Company company)
	{
		startPage();
        List<Company> list = companyService.selectCompanyList(company);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业列表
	 */
	@RequiresPermissions("village:company:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
    	List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "company");
    }
	
	/**
	 * 新增企业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业
	 */
	@RequiresPermissions("village:company:add")
	@Log(title = "企业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Company company)
	{		
		return toAjax(companyService.insertCompany(company));
	}

	/**
	 * 修改企业
	 */
	@GetMapping("/edit/{cid}")
	public String edit(@PathVariable("cid") Integer cid, ModelMap mmap)
	{
		Company company = companyService.selectCompanyById(cid);
		mmap.put("company", company);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业
	 */
	@RequiresPermissions("village:company:edit")
	@Log(title = "企业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Company company)
	{		
		return toAjax(companyService.updateCompany(company));
	}
	
	/**
	 * 删除企业
	 */
	@RequiresPermissions("village:company:remove")
	@Log(title = "企业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyService.deleteCompanyByIds(ids));
	}
	
}
