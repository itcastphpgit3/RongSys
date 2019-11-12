package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.TbStaff;
import com.ruoyi.village.service.ITbStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作员 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-11-03
 */
@Controller
@RequestMapping("/village/tbStaff")
public class TbStaffController extends BaseController
{
    private String prefix = "village/tbStaff";
	
	@Autowired
	private ITbStaffService tbStaffService;
	
	@RequiresPermissions("village:tbStaff:view")
	@GetMapping()
	public String tbStaff()
	{
	    return prefix + "/tbStaff";
	}
	
	/**
	 * 查询工作员列表
	 */
	@RequiresPermissions("village:tbStaff:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbStaff tbStaff)
	{
		startPage();
        List<TbStaff> list = tbStaffService.selectTbStaffList(tbStaff);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工作员列表
	 */
	@RequiresPermissions("village:tbStaff:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbStaff tbStaff)
    {
    	List<TbStaff> list = tbStaffService.selectTbStaffList(tbStaff);
        ExcelUtil<TbStaff> util = new ExcelUtil<TbStaff>(TbStaff.class);
        return util.exportExcel(list, "tbStaff");
    }
	
	/**
	 * 新增工作员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工作员
	 */
	@RequiresPermissions("village:tbStaff:add")
	@Log(title = "工作员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbStaff tbStaff)
	{		
		return toAjax(tbStaffService.insertTbStaff(tbStaff));
	}

	/**
	 * 修改工作员
	 */
	@GetMapping("/edit/{stid}")
	public String edit(@PathVariable("stid") String stid, ModelMap mmap)
	{
		TbStaff tbStaff = tbStaffService.selectTbStaffById(stid);
		mmap.put("tbStaff", tbStaff);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工作员
	 */
	@RequiresPermissions("village:tbStaff:edit")
	@Log(title = "工作员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbStaff tbStaff)
	{		
		return toAjax(tbStaffService.updateTbStaff(tbStaff));
	}
	
	/**
	 * 删除工作员
	 */
	@RequiresPermissions("village:tbStaff:remove")
	@Log(title = "工作员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbStaffService.deleteTbStaffByIds(ids));
	}
	
}
