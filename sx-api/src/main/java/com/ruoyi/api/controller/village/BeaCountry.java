package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.*;
import com.ruoyi.village.service.IHouseMemberInfoService;
import com.ruoyi.village.service.ILinkService;
import com.ruoyi.village.service.IVillageplanService;
import com.ruoyi.village.util.bFileUtil1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/beaCountry")
@CrossOrigin
@Api(value = "村务模块 - 美丽乡村API类")
public class BeaCountry extends BaseController {
    @Autowired
    private IVillageplanService villageplanService;
    @Autowired
    private IOrganizationService organizationService;
    @Autowired
    private ILinkService linkService;

    @GetMapping("/ListBeaCountry")
    @CrossOrigin
    @ApiOperation(value = "美丽乡村列表")
    public RongApiRes selectBeaCountry(pubObjApi beavill){
        beavill.setPageIndex((beavill.getPageIndex()-1)*beavill.getPageSize());
        List<Villageplan> res;
        List<String> allaid = organizationService.listNextAid(beavill.getAid());
        if (allaid.isEmpty()){
            allaid.add(beavill.getAid());
            beavill.setListaid(allaid);
            res = villageplanService.selectBeaCountryListByid(beavill);
        }else {
            //获得所有的子 aid 放入 list
            List<String> temp;
            temp = organizationService.listNextAid(allaid.get(0));
            for(int i = 1; i < allaid.size(); i++){
                List<String> l = organizationService.listNextAid(allaid.get(i));
                if (!l.isEmpty()){
                    temp.addAll(l);
                }
            }
            allaid.addAll(temp);
            // 遍历所有的 aid 信息然后装入结果
            beavill.setListaid(allaid);
            res = villageplanService.selectBeaCountryListByid(beavill);
        }
        return RongApiService.get_list(res);
    }

    @PostMapping("/insertBeaCountry")
    @CrossOrigin
    @ApiOperation(value = "新增美丽乡村")
    public AjaxResult insertBeaCountry(Villageplan villageplan,@RequestParam(value = "files", required = false) MultipartFile file,
                                       @RequestParam(value = "filename", required = false) String fname,
                                       @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                       @RequestParam(value = "fsize",required = false) String fsize )
    {
        return toAjax(villageplanService.insertVillageplan(villageplan));
    }

    @GetMapping("/Link")
    @CrossOrigin
    @ApiOperation(value = "链接列表")
    public RongApiRes selectLinkList(Link link){

        return RongApiService.get_list(linkService.selectLinkList(link));
    }
}
