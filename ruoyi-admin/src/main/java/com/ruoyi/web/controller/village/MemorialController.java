package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.village.domain.Memorial;
import com.ruoyi.village.service.IMemorialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	@Autowired
	private ISysUserService sysUserService;
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
		SysUser currentUser = ShiroUtils.getSysUser();
		int userid = Integer.parseInt(String.valueOf(currentUser.getUserId()));
		memorial.setUid(userid);
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
	public String add(ModelMap mmap)
	{
		//从session中获取当前登陆用户的 username、phone、userid
		SysUser currentUser = ShiroUtils.getSysUser();
		String username =  currentUser.getUserName();
		Long userid =  currentUser.getUserId();
		String aid;
		int returnId = new Long(userid).intValue();
		//通过所获取的userid去广播用户表中查询用户所属区域的Aid
		aid = sysUserService.selectAid(returnId);
		//	将aid、fname、uname传至add.html中
		mmap.put("aid", aid);//这里获得的aid是来自ry-》tb_user_admin
		mmap.put("userid", userid);
		mmap.put("uname", username);
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
