package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Villageplan;
import com.ruoyi.village.domain.Worklog;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.IVillageplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beaCountry")
@CrossOrigin
@Api(value = "村务模块 - 美丽乡村API类")
public class BeaCountry extends BaseController {
    @Autowired
    private IVillageplanService villageplanService;

    @GetMapping("/ListBeaCountry")
    @CrossOrigin
    @ApiOperation(value = "美丽乡村列表")
    public RongApiRes selectBeaCountry(pubObjApi beavill){
        beavill.setPageIndex((beavill.getPageIndex()-1)*beavill.getPageSize());
        return RongApiService.get_list(villageplanService.selectBeaCountryListByid(beavill));
    }

    @PostMapping("/insertBeaCountry")
    @CrossOrigin
    @ApiOperation(value = "新增美丽乡村")
    public AjaxResult insertBeaCountry(Villageplan villageplan)
    {
        return toAjax(villageplanService.insertVillageplan(villageplan));
    }

}
