package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Company;
import com.ruoyi.village.domain.Project;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@CrossOrigin
@Api(value = "企业信息")
public class Acompany extends BaseController {
    @Autowired
    private ICompanyService companyService;

    @GetMapping("/companylist")
    @CrossOrigin
    @ApiOperation(value = "企业信息列表")
    public RongApiRes selectCompanyList(pubObjApi company)
    {
        company.setPageIndex((company.getPageIndex()-1)*company.getPageSize());
        return RongApiService.get_list(companyService.selectCompanyListById(company));
    }

    @PostMapping("/insertcompany")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public AjaxResult insertCompany(Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }
}
