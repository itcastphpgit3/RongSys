package com.ruoyi.api.controller.iot;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.village.domain.Weatherdata;
import com.ruoyi.village.service.IWeatherdataService;
import com.ruoyi.framework.web.base.BaseController;
/**
 * 采集天气信息 控制层
 *
 * @author hfz
 * @date 2019-10-06
 */
@RestController
@RequestMapping("/api/iot/weatherdata")
@CrossOrigin
@Api(value = "天气信息接口")
public class WeatherdataController extends BaseController
{

    @Autowired
    private IWeatherdataService weatherdataService;


    /**
     * 查询天气信息采集列表
     */
    @CrossOrigin
    @GetMapping("/list")
    @ApiOperation(value = "查询天气信息采集列表")
    public RongApiRes list(Weatherdata weatherdata)
    {

        return RongApiService.get_list(weatherdataService.selectWeatherdataList(weatherdata));
    }




}