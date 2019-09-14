package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.AreaGrouping;
import com.ruoyi.broad.mapper.AreaGroupingMapper;
import com.ruoyi.broad.service.IAreaGroupingService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/8/2.
 * @author cx
 * 分组管理实现
 */
@Service
public class AreaGroupingServiceImpl implements IAreaGroupingService{
    /**
   * 查询分组列表，连表查询
   *
   * @return 终端分组列表
   */
    @Autowired
    private AreaGroupingMapper areaGroupingMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<AreaGrouping> listAreaGrouping(AreaGrouping areaGrouping)
    {
        return areaGroupingMapper.listAreaGrouping(areaGrouping);
    }

    /**
    * 更新分组列表
    *
    * @return 终端分组列表
    */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int updateAreaGrouping(AreaGrouping areaGrouping)
    {
        return areaGroupingMapper.updateAreaGrouping(areaGrouping);
    }
    /**
    * 插入分组列表
    *
    * @return 终端分组列表
    */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertAreaGrouping(AreaGrouping areaGrouping)
    {
        return areaGroupingMapper.insertAreaGrouping(areaGrouping);
    }
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteAreaGroupingByIds(String ids)
    {
        return areaGroupingMapper.deleteAreaGroupingByIds(Convert.toStrArray(ids));
    }
}
