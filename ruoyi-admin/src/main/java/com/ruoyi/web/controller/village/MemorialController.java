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
import com.ruoyi.village.domain.Memorial;
import com.ruoyi.village.service.IMemorialService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 备忘录 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/village/memorial")
public class MemorialController extends BaseController
{
    private String prefix = "village/memorial";
	
	@Autowired
	private IMemorialService memorialService;
	
	@RequiresPermissions("village:memorial:view")
	@GetMapping()
	public String memorial()
	{
	    return prefix + "/memorial";
	}
	
	/**
	 * 查询备忘录列表
	 */
	@RequiresPermissions("village:memorial:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Memorial memorial)
	{
		startPage();
        List<Memorial> list = memorialService.selectMemorialList(memorial);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出备忘录列表
	 */
	@RequiresPermissions("village:memorial:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Memorial memorial)
    {
    	List<Memorial> list = memorialService.selectMemorialList(memorial);
        ExcelUtil<Memorial> util = new ExcelUtil<Memorial>(Memorial.class);
        return util.exportExcel(list, "memorial");
    }
	
	/**
	 * 新增备忘录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存备忘录
	 */
	@RequiresPermissions("village:memorial:add")
	@Log(title = "备忘录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Memorial memorial)
	{		
		return toAjax(memorialService.insertMemorial(memorial));
	}

	/**
	 * 修改备忘录
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") Integer mid, ModelMap mmap)
	{
		Memorial memorial = memorialService.selectMemorialById(mid);
		mmap.put("memorial", memorial);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存备忘录
	 */
	@RequiresPermissions("village:memorial:edit")
	@Log(title = "备忘录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Memorial memorial)
	{		
		return toAjax(memorialService.updateMemorial(memorial));
	}
	
	/**
	 * 删除备忘录
	 */
	@RequiresPermissions("village:memorial:remove")
	@Log(title = "备忘录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memorialService.deleteMemorialByIds(ids));
	}
	
}
