package com.ruoyi.village.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.village.mapper.WeatherdataMapper;
import com.ruoyi.village.domain.Weatherdata;
import com.ruoyi.village.service.IWeatherdataService;
import com.ruoyi.common.support.Convert;
/**
 * 采集天气信息 服务层实现
 *
 * @author hfz
 * @date 2019-10-06
 */
@Service
public class WeatherdataServiceImpl implements IWeatherdataService
{
    @Autowired
    private WeatherdataMapper weatherdataMapper;

    /**
     * 查询采集天气信息
     *
     * @param  id 采集天气信息ID
     * @return 采集天气信息
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public Weatherdata selectWeatherdataById(Integer id)
    {
        return weatherdataMapper.selectWeatherdataById(id);
    }

    /**
     * 查询采集天气信息id
     *
     * @param weatherdata 采集天气信息
     * @return 天气信息集合
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<Weatherdata> selectWeatherdataList(Weatherdata weatherdata)
    {
        return weatherdataMapper.selectWeatherdataList(weatherdata);
    }

    /**
     * 新增天气采集信息
     *
     * @param weatherdata 天气采集信息
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int insertWeatherdata(Weatherdata weatherdata)
    {
        return weatherdataMapper.insertWeatherdata(weatherdata);
    }

    /**
     * 修改天气采集信息
     *
     * @param weatherdata 天气采集信息
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int updateWeatherdata(Weatherdata weatherdata)
    {
        return weatherdataMapper.updateWeatherdata(weatherdata);
    }

    /**
     * 删除天气采集信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deleteWeatherdataByIds(String ids)
    {
        return weatherdataMapper.deleteWeatherdataByIds(Convert.toStrArray(ids));
    }

}
