package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Worklog;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.IProjectService;
import com.ruoyi.village.domain.Project;
import com.ruoyi.village.service.IWorklogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
@Api(value = "村务模块 - 项目")
public class VProject extends BaseController {
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IWorklogService workLogService;
    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public RongApiRes searchAll(Project project )
    {
        return RongApiService.get_list(projectService.selectProjectList(project));
    }

    @PostMapping("/insert")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public AjaxResult insertProject(Project project )
    {
        return toAjax(projectService.insertProject(project));
    }

    @GetMapping("/pro_all")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public RongApiRes searchProAll(pubObjApi project )
    {
        project.setPageIndex((project.getPageIndex()-1)*project.getPageSize());
        List<Project> res;
        List<String> allaid = organizationService.listNextAid(project.getAid());
        if (allaid.isEmpty()){
            allaid.add(project.getAid());
            project.setListaid(allaid);
            res = projectService.selectProjectListForapp(project);
        }else {
            //获得所有的子 aid 放入 list
            List<String> temp;
            temp = organizationService.listNextAid(allaid.get(0));
            for (int i = 1; i < allaid.size(); i++){
                List<String> l = organizationService.listNextAid(allaid.get(i));
                if (!l.isEmpty()){
                    temp.addAll(l);
                }
            }
            allaid.addAll(temp);
            // 遍历所有的 aid 信息然后装入结果
            project.setListaid(allaid);
            res = projectService.selectProjectListForapp(project);
        }
        return RongApiService.get_list(res);
    }

    @GetMapping("/ListWorkLog")
    @CrossOrigin
    @ApiOperation(value = "工作记录列表")
    public RongApiRes selectWorkLog(pubObjApi workLog){
        workLog.setPageIndex((workLog.getPageIndex()-1)*workLog.getPageSize());
        return RongApiService.get_list(workLogService.selectWorklogListByid(workLog));
    }

    @PostMapping("/insertWorkLog")
    @CrossOrigin
    @ApiOperation(value = "新增工作记录")
    public AjaxResult insertWorkLog(Worklog worklog )
    {
        return toAjax(workLogService.insertWorklog(worklog));
    }

}
