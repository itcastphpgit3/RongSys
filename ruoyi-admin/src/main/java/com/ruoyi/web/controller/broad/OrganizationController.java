package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.domain.TerminalTels;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 终端信息操作处理
 *
 * @author cx
 * @date 2019-09-21
 */
@Controller
@RequestMapping("/broad/organization")
public class OrganizationController extends BaseController
{
	private String prefix = "broad/organization";

	@Autowired
	private IOrganizationService organizationService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private IAreaService areaService;


	@RequiresPermissions("broad:organization:view")
	@GetMapping()
	public String organization()
	{
		return prefix + "/organization";
	}



	/**
	 * 查询终端信息列表
	 */
//	@RequiresPermissions("broad:organization:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Organization organization)
	{
		startPage();
		List<Organization> list = organizationService.selectOrganizationList1(organization);
		return getDataTable(list);
	}

	/**
	 * 加载节目单播出终端选择列表树
	 */
	@GetMapping("/listProBroadTree")
	@ResponseBody
	public List<Map<String, Object>> listProBroadTree()
	{
		List<Map<String, Object>> tree = messageService.selectMessageList(new BroadMessage());
		return tree;
	}

	/**
	 * 删除终端信息
	 */
	@Log(title = "终端信息删除", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(organizationService.deleteOrganizationByIds(ids));
	}

	/**
	 * 编辑终端信息
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") String tid, ModelMap mmap)
	{
        Organization organization = organizationService.selectOrganizationByTid(tid);
        mmap.put("organization", organization);
        return prefix + "/edit";
	}
	/**
	 * 编辑保存终端信息
	 */
	@RequiresPermissions("broad:organization:edit")
	@Log(title = "终端信息修改", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Organization organization)
	{
		int test = organizationService.updateOrganization(organization);
//        int test1 = organizationService.updateUsername(organization);
		if (test == 0)
		{
			test = test + 1;
		}
		return toAjax(test);
	}

	@GetMapping("/add")
	public String add(){
		return prefix + "/add";
	}


	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Organization organization){
		return toAjax(organizationService.insertOrganization(organization));
	}

	/**
	 * 加载区域列表树
	 * @description 目前村务调用了这个接口广播的暂时没有调用
	 *
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
	 * @description 目前村务在调用此接口
	 */
	@GetMapping("/selectAidTree")
	public String selectAidTree()
	{
		return prefix + "/aidTree";
	}


	/** @author cx
	 * @description 导出终端数据
	 *
	 * @param organization
	 * @return 终端管理表集合
	 */
	@Log(title = "终端管理", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Organization organization)
	{
		List<Organization> list = organizationService.exportOrganization(organization);
		ExcelUtil<Organization> util = new ExcelUtil<Organization>(Organization.class);
		return util.exportExcel(list, "终端管理表");
	}

	/**
	 * @description 选择终端树，多个地方调用了此接口
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/selectOrganizationTree/{aid}")
	public String selectOrganizationTree(@PathVariable("aid") String aid, ModelMap mmap)
	{
		mmap.put("organization", areaService.selectAreaById(aid));
		/*return prefix + "/tree";*/
		return prefix + "/listProBroadTree";
	}
	@GetMapping("/phoneEdit/{tid}")
	public String phoneEdit(@PathVariable("tid") String tid, ModelMap mmap){
		return prefix + "/phoneEdit";
	}
	@PostMapping("/phoneEdit/{tid}")
	@ResponseBody
	public List<TerminalTels> phoneEditpost(@PathVariable("tid") String tid, ModelMap mmap){
		List<TerminalTels> terminalTels= organizationService.selectTelsByTid(tid);
		mmap.put("terminalTels", terminalTels);
		return terminalTels;
	}

	@PostMapping("/addphoneedit")
	@ResponseBody
	public int addphoneEdit(TerminalTels terminalTels){
		return organizationService.addphoneEdit(terminalTels);
	}

	@GetMapping("/deletephoneedit/{telid}")
	@ResponseBody
	public String deletephoneedit(@PathVariable("telid") String telid){
		if(organizationService.deletephoneedit(telid)==1);
		return "操作成功";
	}
}

