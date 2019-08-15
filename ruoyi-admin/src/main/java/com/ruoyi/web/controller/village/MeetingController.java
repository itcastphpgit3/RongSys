package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Meeting;
import com.ruoyi.village.service.IMeetingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会议记录 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/village/meeting")
public class MeetingController extends BaseController
{
    private String prefix = "village/meeting";
	
	@Autowired
	private IMeetingService meetingService;
	
	@RequiresPermissions("village:meeting:view")
	@GetMapping()
	public String meeting()
	{
	    return prefix + "/meeting";
	}
	
	/**
	 * 查询会议记录列表
	 */
	@RequiresPermissions("village:meeting:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Meeting meeting)
	{
		startPage();
        List<Meeting> list = meetingService.selectMeetingList(meeting);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会议记录列表
	 */
	@RequiresPermissions("village:meeting:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Meeting meeting)
    {
    	List<Meeting> list = meetingService.selectMeetingList(meeting);
        ExcelUtil<Meeting> util = new ExcelUtil<Meeting>(Meeting.class);
        return util.exportExcel(list, "meeting");
    }
	
	/**
	 * 新增会议记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会议记录
	 */
	@RequiresPermissions("village:meeting:add")
	@Log(title = "会议记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Meeting meeting)
	{		
		return toAjax(meetingService.insertMeeting(meeting));
	}

	/**
	 * 修改会议记录
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") Integer mid, ModelMap mmap)
	{
		Meeting meeting = meetingService.selectMeetingById(mid);
		mmap.put("meeting", meeting);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会议记录
	 */
	@RequiresPermissions("village:meeting:edit")
	@Log(title = "会议记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Meeting meeting)
	{		
		return toAjax(meetingService.updateMeeting(meeting));
	}
	
	/**
	 * 删除会议记录
	 */
	@RequiresPermissions("village:meeting:remove")
	@Log(title = "会议记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(meetingService.deleteMeetingByIds(ids));
	}
	
}
