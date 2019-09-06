package com.ruoyi.api.controller.system;



import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Api(value = "用户信息")
public class User extends BaseController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private SysPasswordService passwordService;

    @PostMapping("/resetPwd")
    @CrossOrigin
    @ApiOperation(value = "修改用户密码信息")
    public AjaxResult resetUserPwd(SysUser user,String new_pwd)
    {
        if(sysUserService.selectUserById(user.getUserId()).getPassword().equals(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()))){

            user.setSalt(ShiroUtils.randomSalt());
            user.setPassword(passwordService.encryptPassword(user.getLoginName(), new_pwd, user.getSalt()));
            return toAjax(sysUserService.resetUserPwd(user));
        }else{
            String msg = "修改密码失败";
            return error(msg);
        }

    }

    @PostMapping("/upUser")
    @CrossOrigin
    @ApiOperation(value = "修改用户详细信息")
    public AjaxResult updateUser(SysUser user)
    {
        return toAjax(sysUserService.updateUserInfo(user));
    }

    @GetMapping("/selectById")
    @CrossOrigin
    @ApiOperation(value = "通过用户ID查询用户")
    public RongApiRes selectUserById(Long userId)
    {
        return RongApiService.get_bean(sysUserService.selectUserById(userId));
    }
    @GetMapping("/selectByName")
    @CrossOrigin
    @ApiOperation(value = "通过用户名查询用户")
    public RongApiRes selectUserByLoginName(String userName)
    {
        return RongApiService.get_bean(sysUserService.selectUserByLoginName(userName));
    }

    @PostMapping("/login")
    @CrossOrigin
    @ApiOperation(value = "用户登录")
    public AjaxResult ajaxLogin(String loginid, String pwd, Boolean rememberMe)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(loginid, pwd, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            return AjaxResult.success(sysUserService.selectUserForAppByLoginName(loginid));
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/selectMenu")
    @CrossOrigin
    @ApiOperation(value = "通过用户名查询用户")
    public RongApiRes selectMenuById(SysUser user)
    {
        return RongApiService.get_list(menuService.selectMenusByUser(user));
    }
}
