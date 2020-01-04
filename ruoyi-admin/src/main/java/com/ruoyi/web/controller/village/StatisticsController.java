package com.ruoyi.web.controller.village;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.domain.VillagerInfo;
import com.ruoyi.village.service.IPartymemberService;
import com.ruoyi.village.service.IVillagerInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZX
 * @Description:
 * @Date: Create in 11:10 2019/11/10
 */
@Controller
@RequestMapping("/village/statistics")
public class StatisticsController extends BaseController {

    private String prefix = "village/statistics";

    @Autowired
    private IPartymemberService PartymemberService;

    @RequiresPermissions("village:statistics:view")
    @GetMapping()
    public String villagerInfo()
    {
        return prefix + "/statistics";
    }

    @RequiresPermissions("village:statistics:list")
    @PostMapping("/count")
    @ResponseBody
    public String Groupedu(String grouptype)
    {

        List<Partymember> list = PartymemberService.selectPartymemberBygrouptype(grouptype);
        Integer count=list.size();//总数
        Integer edu1=0;//硕士研究生
        Integer edu2=0;//本科
        Integer edu3=0;//大专
        Integer edu4=0;//中专
        Integer edu5=0;//高中
        Integer edu6=0;//初中
        Integer edu7=0;//小学
        for(int i=0;i<count;i++){
            if("硕士研究生".equals(list.get(i).getEdulevel())) {
                edu1++;
            }else if("本科".equals(list.get(i).getEdulevel())){
                edu2++;
            }else if("大专".equals(list.get(i).getEdulevel())){
                edu3++;
            }else if("中专".equals(list.get(i).getEdulevel())){
                edu4++;
            }else if("高中".equals(list.get(i).getEdulevel())){
                edu5++;
            }else if("初中".equals(list.get(i).getEdulevel())){
                edu6++;
            }else{
                edu7++;
            }


        }
        String result=count.toString()+'|'+edu1.toString()+'|'+ edu2.toString()+edu3.toString()+'|'+edu4.toString()+'|'+edu5.toString()+'|'+edu6.toString()+'|'+edu7.toString();

        return result;
    }


}
