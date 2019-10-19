package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Weatherdata;
import java.util.List;

/**
 * 采集天气信息 数据层
 *
 * @author hfz
 * @date 2019-10-06
 */
public interface WeatherdataMapper {
    /**
     * 查询采集天气信息
     *
     * @param id 采集天气信息ID
     * @return 采集天气信息
     */
    public Weatherdata selectWeatherdataById(Integer id);

    /**
     * 查询采集天气信息
     *
     * @param weatherdata 采集天气信息
     * @return 采集天气信息集合
     */
    public List<Weatherdata> selectWeatherdataList(Weatherdata weatherdata);

    /**
     * 新增采集天气信息
     *
     * @param weatherdata 采集天气信息
     * @return 结果
     */
    public int insertWeatherdata(Weatherdata weatherdata);

    /**
     * 修改采集天气信息
     *
     * @param weatherdata 采集天气信息
     * @return 结果
     */
    public int updateWeatherdata(Weatherdata weatherdata);

    /**
     * 删除采集天气信息
     *
     * @param id 采集天气信息ID
     * @return 结果
     */
    public int deleteWeatherdataById(Integer id);

    /**
     * 批量删除采集天气信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeatherdataByIds(String[] ids);

}

