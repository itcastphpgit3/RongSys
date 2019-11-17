package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.TbHuodong;
import com.ruoyi.village.service.ITbHuodongService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 党员活动 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-11-16
 */
@Controller
@RequestMapping("/village/tbHuodong")
public class TbHuodongController extends BaseController
{
    private String prefix = "village/tbHuodong";
	
	@Autowired
	private ITbHuodongService tbHuodongService;
	
	@RequiresPermissions("village:tbHuodong:view")
	@GetMapping()
	public String tbHuodong()
	{
	    return prefix + "/tbHuodong";
	}
	
	/**
	 * 查询党员活动列表
	 */
	@RequiresPermissions("village:tbHuodong:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbHuodong tbHuodong)
	{
		startPage();
        List<TbHuodong> list = tbHuodongService.selectTbHuodongList(tbHuodong);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出党员活动列表
	 */
	@RequiresPermissions("village:tbHuodong:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbHuodong tbHuodong)
    {
    	List<TbHuodong> list = tbHuodongService.selectTbHuodongList(tbHuodong);
        ExcelUtil<TbHuodong> util = new ExcelUtil<TbHuodong>(TbHuodong.class);
        return util.exportExcel(list, "tbHuodong");
    }
	
	/**
	 * 新增党员活动
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存党员活动
	 */
	@RequiresPermissions("village:tbHuodong:add")
	@Log(title = "党员活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbHuodong tbHuodong)
	{		
		return toAjax(tbHuodongService.insertTbHuodong(tbHuodong));
	}

	/**
	 * 修改党员活动
	 */
	@GetMapping("/edit/{hdid}")
	public String edit(@PathVariable("hdid") Integer hdid, ModelMap mmap)
	{
		TbHuodong tbHuodong = tbHuodongService.selectTbHuodongById(hdid);
		mmap.put("tbHuodong", tbHuodong);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存党员活动
	 */
	@RequiresPermissions("village:tbHuodong:edit")
	@Log(title = "党员活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbHuodong tbHuodong)
	{		
		return toAjax(tbHuodongService.updateTbHuodong(tbHuodong));
	}
	
	/**
	 * 删除党员活动
	 */
	@RequiresPermissions("village:tbHuodong:remove")
	@Log(title = "党员活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbHuodongService.deleteTbHuodongByIds(ids));
	}
	
}
