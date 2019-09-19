package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Company;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@CrossOrigin
@Api(value = "企业信息")
public class Acompany extends BaseController {
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/companylist")
    @CrossOrigin
    @ApiOperation(value = "企业信息列表")
    public RongApiRes selectCompanyList(pubObjApi company)
    {
        company.setPageIndex((company.getPageIndex()-1)*company.getPageSize());
        List<Company> res;
        List<String> allaid = organizationService.listNextAid(company.getAid());
        if (allaid.isEmpty()){
            allaid.add(company.getAid());
            company.setListaid(allaid);
            res = companyService.selectCompanyListById(company);
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
            company.setListaid(allaid);
            res = companyService.selectCompanyListById(company);
        }
        return RongApiService.get_list(res);
    }

    @PostMapping("/insertcompany")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public AjaxResult insertCompany(Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }
}
