package com.synjones.cloudcard.permission.provider.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.synjones.cloudcard.permission.core.service.PermissionService;
import com.synjones.cloudcard.permission.core.service.utils.JWTUtil;
import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.enums.MngRespCodeEnums;
import com.synjones.cloudcard.permission.provider.facade.PermissionProvider;
import com.synjones.cloudcard.permission.provider.mapper.ProviderObjectMapper;
import com.synjones.cloudcard.permission.provider.models.*;
import com.synjones.common.share.request.BaseCommonRequest;
import com.synjones.common.share.request.BasePageRequest;
import com.synjones.common.share.response.BaseCommonResponse;
import com.synjones.common.share.response.BasePageResponse;
import com.synjones.common.share.response.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Service(application = "${dubbo.application.id}", protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}" )
public class PermissionProviderImpl implements PermissionProvider {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ProviderObjectMapper mapper;

    /**
     * 根据操作员角色查询菜单
     * @param req
     * @return
     */
    @Override
    public BasePageResponse<MngResourceRo> menuTree(BaseCommonRequest<MngUserRo> req) {
        return null;
    }

    /**
     * 多条件查询操作员
     * @param req
     * @param args
     * @return
     */
    @Override
    public BasePageResponse<MngUserRo> listUser(BasePageRequest<MngUserRo> req, CommonArgs args) {
        BasePageResponse<MngUserRo> response = new BasePageResponse<>();
        PageInfo<MngUserRo> pageInfo = permissionService.listUser(mapper.mapper(req, MngPageInfoRo.class), req.getObj(), args);
        response.setObjs(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());
        response.setCode(MngRespCodeEnums.SUCCESS.getRespCode(), MngRespCodeEnums.SUCCESS.getRespInfo());
        return response;
    }

    /**
     * 新增操作员
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse addUser(BaseCommonRequest<MngUserRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 修改操作员信息
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse editUser(BaseCommonRequest<MngUserRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 删除操作员信息
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse delUser(BaseCommonRequest<MngUserRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 修改操作员状态
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse updateStatus(BaseCommonRequest<MngUserRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 根据操作员及type值查询操作员页面的角色树
     * @param req 操作员信息
     * @param type 类型
     * @param args 区域信息
     * @return
     */
    @Override
    public BasePageResponse<MngRoleRo> roleTreeForUser(BaseCommonRequest<MngUserRo> req, String type, CommonArgs args) {
        return null;
    }

    /**
     * 根据操作员的角色及operCode值查询角色列表
     * @param req
     * @param args
     * @return
     */
    @Override
    public BasePageResponse<MngRoleRo> listRole(BasePageRequest<MngRoleRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 新增角色
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse addRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 修改角色
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse editRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 删除角色
     * @param req
     * @param args
     * @return
     */
    @Override
    public BaseResponse delRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args) {
        return null;
    }

    /**
     * 根据角色及type查询角色页面的角色树
     * @param req 角色信息
     * @param type 类型
     * @param args 区域信息
     * @return
     */
    @Override
    public BasePageResponse<MngRoleRo> roleTreeForRole(BaseCommonRequest<MngRoleRo> req, String type, CommonArgs args) {
        return null;
    }

    /**
     * 根据角色和type值查询资源树
     * @param req 角色信息
     * @param type 类型
     * @return
     */
    @Override
    public BasePageResponse<MngResourceRo> resourceTree(BaseCommonRequest<MngRoleRo> req, String type) {
        return null;
    }

    /**
     * 查询日志列表
     * @param req
     * @return
     */
    @Override
    public BasePageResponse<MngOperLogRo> listLog(BasePageRequest<MngOperLogRo> req) {
        return null;
    }

    /**
     * 新增日志记录
     * @param log
     * @return
     */
    @Override
    public BaseResponse addLog(BaseCommonRequest<MngOperLogRo> log) {
        return null;
    }

    /**
     * 身份认证
     *   从请求中获取token，若token为空返回false
     *   从token中获取用户信息，验证token，验证成功返回true，失败返回false
     *   调用方根据返回值判断，true则放行，false则跳转登录
     * @param req
     * @param resp
     * @return
     */
    @Override
    public Boolean authentication(ServletRequest req, ServletResponse resp) {
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader("Token");
        if (StringUtils.isBlank(token))
            return false;
        //验证token是否过期
        if (JWTUtil.isTokenExpired(token))
            return false;
        String username = JWTUtil.getUsername(token);
        Boolean bl = permissionService.authentication(token,username);
        return bl;
    }


    /**
     * 操作越权验证
     * @param args 区域信息
     * @return
     */
    @Override
    public Boolean areaAuthentication(CommonArgs args) {
        return null;
    }

    /**
     * 多条件查询第三方菜单列表
     * @param req
     * @return
     */
    @Override
    public BasePageResponse<MngResourceRo> listThirdMenu(BasePageRequest<MngResourceRo> req) {
        return null;
    }

    /**
     * 新增第三方菜单
     * @param req
     * @return
     */
    @Override
    public BaseResponse addThirdMenu(BaseCommonRequest<MngResourceRo> req) {
        return null;
    }

    /**
     * 修改第三方菜单
     * @param req
     * @return
     */
    @Override
    public BaseResponse editThirdMenu(BaseCommonRequest<MngResourceRo> req) {
        return null;
    }

    /**
     * 删除第三方菜单
     * @param req
     * @return
     */
    @Override
    public BaseResponse delThirdMenu(BaseCommonRequest<MngResourceRo> req) {
        return null;
    }

    /**
     * 生成验证码
     * @param random 随机值
     */
    @Override
    public void verify(String random) {

    }

    /**
     * 登录
     * @param req 登录信息
     * @param imgCode 验证码
     * @return
     */
    @Override
    public BaseCommonResponse<String> login(BaseCommonRequest<MngUserRo> req, String imgCode) {
        MngUserRo userRo = req.getObj();
        String token = permissionService.login(userRo, imgCode);
        BaseCommonResponse<String> response = new BaseCommonResponse<>();
        response.setObj(token);
        response.setCode(MngRespCodeEnums.SUCCESS.getRespCode(),MngRespCodeEnums.SUCCESS.getRespInfo());
        return response;
    }
}
