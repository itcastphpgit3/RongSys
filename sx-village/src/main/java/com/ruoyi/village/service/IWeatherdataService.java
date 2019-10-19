package com.ruoyi.village.service;

import com.ruoyi.village.domain.Weatherdata;
import java.util.List;

/**
 * 采集天气信息 服务层
 *
 * @author hfz
 * @date 2019-10-06
 */
public interface IWeatherdataService {
    /**
     * 查询天气采集信息
     *
     * @param  id 采集天气信息ID
     * @return 天气信息
     */
    public Weatherdata selectWeatherdataById(Integer id);

    /**
     * 天气采集信息公开列表
     *
     * @param weatherdata 采集天气信息
     * @return 采集天气信息集合
     */
    public List<Weatherdata> selectWeatherdataList(Weatherdata weatherdata);

    /**
     * 新增天气采集信息
     *
     * @param weatherdata 采集天气信息
     * @return 结果
     */
    public int insertWeatherdata(Weatherdata weatherdata);

    /**
     * 修改天气采集信息
     *
     * @param weatherdata 采集天气信息
     * @return 结果
     */
    public int updateWeatherdata(Weatherdata weatherdata);

    /**
     * 删除天气采集信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeatherdataByIds(String ids);

}

