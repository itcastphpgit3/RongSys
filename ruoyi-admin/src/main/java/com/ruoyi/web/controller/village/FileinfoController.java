package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Fileinfo;
import com.ruoyi.village.service.IFileinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件夹管理 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-22
 */
@Controller
@RequestMapping("/village/fileinfo")
public class FileinfoController extends BaseController
{
    private String prefix = "village/fileinfo";
	
	@Autowired
	private IFileinfoService fileinfoService;
	
	@RequiresPermissions("village:fileinfo:view")
	@GetMapping()
	public String fileinfo()
	{
	    return prefix + "/fileinfo";
	}

	/**
	 * 查询文件夹管理列表
	 */
	@RequiresPermissions("village:fileinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fileinfo fileinfo)
	{
		startPage();
        List<Fileinfo> list = fileinfoService.selectFileinfoList(fileinfo);
        /*System.out.println("运行到list方法里面啦！！！");*/
		//List<Map<String, Object>> filedata = fileinfoService.selectFileTree(new Fileinfo());
//		System.out.println("！！！下面输出的是filedata数据：");
////		System.out.println(filedata);
		return getDataTable(list);
	}

	/*@GetMapping("/fileData")
	public String fileData(Fileinfo fileinfo,ModelMap mmap)
	{
//		List<Map<String, Object>> filedata = fileinfoService.selectFileTree(new Fileinfo());
		List<Fileinfo> filedata ;
		filedata = fileinfoService.selectFileinfoList(fileinfo);
		System.out.println("！！！下面输出的是filedata数据：");
		System.out.println(filedata);
		mmap.put("aaa","1");
		mmap.put("filedata",filedata);
		return prefix + "/fileinfo";
	}*/
	@GetMapping("/fileData")
	@ResponseBody
	public ModelAndView fileData(Fileinfo fileinfo,String str)
	{
		List<Fileinfo> filedata ;
		filedata = fileinfoService.selectFileinfoList(fileinfo);
		System.out.println("！！！下面输出的是filedata数据：");
		System.out.println(filedata);
		Map<String,Object> attribute = new HashMap<String,Object>();
		attribute.put("filedata",filedata);
		return new ModelAndView(prefix + "/fileinfo",attribute);
	}
	/**
	 * 导出文件夹管理列表
	 */
	@RequiresPermissions("village:fileinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fileinfo fileinfo)
    {
    	List<Fileinfo> list = fileinfoService.selectFileinfoList(fileinfo);
        ExcelUtil<Fileinfo> util = new ExcelUtil<Fileinfo>(Fileinfo.class);
        return util.exportExcel(list, "fileinfo");
    }
	
	/**
	 * 新增文件夹管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文件夹管理
	 */
	@RequiresPermissions("village:fileinfo:add")
	@Log(title = "文件夹管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Fileinfo fileinfo)
	{		
		return toAjax(fileinfoService.insertFileinfo(fileinfo));
	}

	/**
	 * 修改文件夹管理
	 */
	@GetMapping("/edit/{fileid}")
	public String edit(@PathVariable("fileid") Integer fileid, ModelMap mmap)
	{
		Fileinfo fileinfo = fileinfoService.selectFileinfoById(fileid);
		mmap.put("fileinfo", fileinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件夹管理
	 */
	@RequiresPermissions("village:fileinfo:edit")
	@Log(title = "文件夹管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Fileinfo fileinfo)
	{		
		return toAjax(fileinfoService.updateFileinfo(fileinfo));
	}
	
	/**
	 * 删除文件夹管理
	 */
	@RequiresPermissions("village:fileinfo:remove")
	@Log(title = "文件夹管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fileinfoService.deleteFileinfoByIds(ids));
	}
	
}
