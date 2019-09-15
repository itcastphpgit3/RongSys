package com.ruoyi.web.controller.village;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.village.domain.Company;
import com.ruoyi.village.service.ICompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

	@Autowired
	private IAreaService areaService;

	@Autowired
	private ISysUserService sysUserService;

	
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
	 * 加载区域列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData()
	{
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		int returnId = new Long(userid).intValue();
		int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
		if(roleid == 1) {
			List<Map<String, Object>> tree = areaService.selectAreaTree(new Area());
			return tree;
		}else {
			String aid;
			aid = sysUserService.selectAid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Aid
			Area update_area = new Area();
			update_area.setAid(aid);
			List<Map<String, Object>> tree = areaService.selectAreaTree(update_area);
			return tree;
		}
	}



	/**
	 * 选择区域树
	 */
	@GetMapping("/selectAidTree")
	public String selectAidTree()
	{
		return prefix + "/aidTree";
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
