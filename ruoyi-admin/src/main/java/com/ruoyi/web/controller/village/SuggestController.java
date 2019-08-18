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
import com.ruoyi.village.domain.Suggest;
import com.ruoyi.village.service.ISuggestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 我的建议 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/village/suggest")
public class SuggestController extends BaseController
{
    private String prefix = "village/suggest";
	
	@Autowired
	private ISuggestService suggestService;
	@Autowired
	private ISysUserService sysUserService;
	@RequiresPermissions("village:suggest:view")
	@GetMapping()
	public String suggest()
	{
	    return prefix + "/suggest";
	}
	
	/**
	 * 查询我的建议列表
	 */
	@RequiresPermissions("village:suggest:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Suggest suggest)
	{
		SysUser currentUser = ShiroUtils.getSysUser();
		int userid = Integer.parseInt(String.valueOf(currentUser.getUserId()));
		suggest.setUid(userid);
		startPage();
        List<Suggest> list = suggestService.selectSuggestList(suggest);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出我的建议列表
	 */
	@RequiresPermissions("village:suggest:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Suggest suggest)
    {
    	List<Suggest> list = suggestService.selectSuggestList(suggest);
        ExcelUtil<Suggest> util = new ExcelUtil<Suggest>(Suggest.class);
        return util.exportExcel(list, "suggest");
    }
	
	/**
	 * 新增我的建议
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
	 * 新增保存我的建议
	 */
	@RequiresPermissions("village:suggest:add")
	@Log(title = "我的建议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Suggest suggest)
	{		
		return toAjax(suggestService.insertSuggest(suggest));
	}

	/**
	 * 修改我的建议
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") Integer mid, ModelMap mmap)
	{
		Suggest suggest = suggestService.selectSuggestById(mid);
		mmap.put("suggest", suggest);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存我的建议
	 */
	@RequiresPermissions("village:suggest:edit")
	@Log(title = "我的建议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Suggest suggest)
	{		
		return toAjax(suggestService.updateSuggest(suggest));
	}
	
	/**
	 * 删除我的建议
	 */
	@RequiresPermissions("village:suggest:remove")
	@Log(title = "我的建议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(suggestService.deleteSuggestByIds(ids));
	}
	
}
