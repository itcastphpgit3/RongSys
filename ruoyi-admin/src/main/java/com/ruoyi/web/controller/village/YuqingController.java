package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Yuqing;
import com.ruoyi.village.service.IYuqingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 舆情上报 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-18
 */
@Controller
@RequestMapping("/village/yuqing")
public class YuqingController extends BaseController
{
    private String prefix = "village/yuqing";
	
	@Autowired
	private IYuqingService yuqingService;
	
	@RequiresPermissions("village:yuqing:view")
	@GetMapping()
	public String yuqing()
	{
	    return prefix + "/yuqing";
	}
	
	/**
	 * 查询舆情上报列表
	 */
	@RequiresPermissions("village:yuqing:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Yuqing yuqing)
	{
		startPage();
        List<Yuqing> list = yuqingService.selectYuqingList(yuqing);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出舆情上报列表
	 */
	@RequiresPermissions("village:yuqing:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Yuqing yuqing)
    {
    	List<Yuqing> list = yuqingService.selectYuqingList(yuqing);
        ExcelUtil<Yuqing> util = new ExcelUtil<Yuqing>(Yuqing.class);
        return util.exportExcel(list, "yuqing");
    }
	
	/**
	 * 新增舆情上报
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存舆情上报
	 */
	@RequiresPermissions("village:yuqing:add")
	@Log(title = "舆情上报", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Yuqing yuqing)
	{		
		return toAjax(yuqingService.insertYuqing(yuqing));
	}

	/**
	 * 修改舆情上报
	 */
	@GetMapping("/edit/{yqid}")
	public String edit(@PathVariable("yqid") Integer yqid, ModelMap mmap)
	{
		Yuqing yuqing = yuqingService.selectYuqingById(yqid);
		mmap.put("yuqing", yuqing);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存舆情上报
	 */
	@RequiresPermissions("village:yuqing:edit")
	@Log(title = "舆情上报", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Yuqing yuqing)
	{		
		return toAjax(yuqingService.updateYuqing(yuqing));
	}
	
	/**
	 * 删除舆情上报
	 */
	@RequiresPermissions("village:yuqing:remove")
	@Log(title = "舆情上报", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(yuqingService.deleteYuqingByIds(ids));
	}
	
}
