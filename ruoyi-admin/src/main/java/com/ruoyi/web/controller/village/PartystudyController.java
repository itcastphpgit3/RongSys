package com.ruoyi.web.controller.village;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.village.domain.Partystudy;
import com.ruoyi.village.service.IPartystudyService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 党员学习 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-25
 */
@Controller
@RequestMapping("/village/partystudy")
public class PartystudyController extends BaseController
{
    private String prefix = "village/partystudy";
	
	@Autowired
	private IPartystudyService partystudyService;
	
	@RequiresPermissions("village:partystudy:view")
	@GetMapping()
	public String partystudy()
	{
	    return prefix + "/partystudy";
	}
	
	/**
	 * 查询党员学习列表
	 */
	@RequiresPermissions("village:partystudy:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Partystudy partystudy)
	{
		startPage();
        List<Partystudy> list = partystudyService.selectPartystudyList(partystudy);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出党员学习列表
	 */
	@RequiresPermissions("village:partystudy:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Partystudy partystudy)
    {
    	List<Partystudy> list = partystudyService.selectPartystudyList(partystudy);
        ExcelUtil<Partystudy> util = new ExcelUtil<Partystudy>(Partystudy.class);
        return util.exportExcel(list, "partystudy");
    }
	
	/**
	 * 新增党员学习
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存党员学习
	 */
	@RequiresPermissions("village:partystudy:add")
	@Log(title = "党员学习", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Partystudy partystudy)
	{		
		return toAjax(partystudyService.insertPartystudy(partystudy));
	}

	/**
	 * 修改党员学习
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") Integer mid, ModelMap mmap)
	{
		Partystudy partystudy = partystudyService.selectPartystudyById(mid);
		mmap.put("partystudy", partystudy);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存党员学习
	 */
	@RequiresPermissions("village:partystudy:edit")
	@Log(title = "党员学习", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Partystudy partystudy)
	{		
		return toAjax(partystudyService.updatePartystudy(partystudy));
	}
	
	/**
	 * 删除党员学习
	 */
	@RequiresPermissions("village:partystudy:remove")
	@Log(title = "党员学习", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(partystudyService.deletePartystudyByIds(ids));
	}
	
}
