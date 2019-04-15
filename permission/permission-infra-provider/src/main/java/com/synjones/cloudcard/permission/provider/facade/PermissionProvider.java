package com.synjones.cloudcard.permission.provider.facade;

import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.models.MngOperLogRo;
import com.synjones.cloudcard.permission.provider.models.MngResourceRo;
import com.synjones.cloudcard.permission.provider.models.MngRoleRo;
import com.synjones.cloudcard.permission.provider.models.MngUserRo;
import com.synjones.common.share.request.BaseCommonRequest;
import com.synjones.common.share.request.BasePageRequest;
import com.synjones.common.share.response.BaseCommonResponse;
import com.synjones.common.share.response.BasePageResponse;
import com.synjones.common.share.response.BaseResponse;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface PermissionProvider {

    /**
     * 根据操作员角色查询菜单
     * @param req
     * @return
     */
    BasePageResponse<MngResourceRo> menuTree(BaseCommonRequest<MngUserRo> req);

    /**
     * 多条件查询操作员
     * @param req
     * @param args
     * @return
     */
    BasePageResponse<MngUserRo> listUser(BasePageRequest<MngUserRo> req, CommonArgs args);

    /**
     * 新增操作员
     * @param req
     * @param args
     * @return
     */
    BaseResponse addUser(BaseCommonRequest<MngUserRo> req, CommonArgs args);

    /**
     * 修改操作员信息
     * @param req
     * @param args
     * @return
     */
    BaseResponse editUser(BaseCommonRequest<MngUserRo> req, CommonArgs args);

    /**
     * 删除操作员信息
     * @param req
     * @param args
     * @return
     */
    BaseResponse delUser(BaseCommonRequest<MngUserRo> req, CommonArgs args);

    /**
     * 修改操作员状态
     * @param req
     * @param args
     * @return
     */
    BaseResponse updateStatus(BaseCommonRequest<MngUserRo> req, CommonArgs args);

    /**
     * 根据操作员及type值查询操作员页面的角色树
     * @param req 操作员信息
     * @param type 类型
     * @param args 区域信息
     * @return
     */
    BasePageResponse<MngRoleRo> roleTreeForUser(BaseCommonRequest<MngUserRo> req, String type, CommonArgs args);

    /**
     * 根据操作员的角色及operCode值查询角色列表
     * @param req
     * @param args
     * @return
     */
    BasePageResponse<MngRoleRo> listRole(BasePageRequest<MngRoleRo> req, CommonArgs args);

    /**
     * 新增角色
     * @param req
     * @param args
     * @return
     */
    BaseResponse addRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args);

    /**
     * 修改角色
     * @param req
     * @param args
     * @return
     */
    BaseResponse editRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args);

    /**
     * 删除角色
     * @param req
     * @param args
     * @return
     */
    BaseResponse delRole(BaseCommonRequest<MngRoleRo> req, CommonArgs args);

    /**
     * 根据角色及type查询角色页面的角色树
     * @param req 角色信息
     * @param type 类型
     * @param args 区域信息
     * @return
     */
    BasePageResponse<MngRoleRo> roleTreeForRole(BaseCommonRequest<MngRoleRo> req, String type, CommonArgs args);

    /**
     * 根据角色和type值查询资源树
     * @param req 角色信息
     * @param type 类型
     * @return
     */
    BasePageResponse<MngResourceRo> resourceTree(BaseCommonRequest<MngRoleRo> req, String type);

    /**
     * 查询日志列表
     * @param req
     * @return
     */
    BasePageResponse<MngOperLogRo> listLog(BasePageRequest<MngOperLogRo> req);

    /**
     * 新增日志记录
     * @param log
     * @return
     */
    BaseResponse addLog(BaseCommonRequest<MngOperLogRo> log);

    /**
     * 身份认证
     * @param req
     * @param resp
     * @return
     */
    Boolean authentication(ServletRequest req, ServletResponse resp );

    /**
     * 操作越权验证
     * @param args
     * @return
     */
    Boolean areaAuthentication(CommonArgs args);

    /**
     * 多条件查询第三方菜单列表
     * @param req
     * @return
     */
    BasePageResponse<MngResourceRo> listThirdMenu(BasePageRequest<MngResourceRo>  req);

    /**
     * 新增第三方菜单
     * @param req
     * @return
     */
    BaseResponse addThirdMenu(BaseCommonRequest<MngResourceRo>  req);

    /**
     * 修改第三方菜单
     * @param req
     * @return
     */
    BaseResponse editThirdMenu(BaseCommonRequest<MngResourceRo>  req);

    /**
     * 删除第三方菜单
     * @param req
     * @return
     */
    BaseResponse delThirdMenu(BaseCommonRequest<MngResourceRo>  req);

    /**
     * 生成验证码
     * @param random
     */
    void verify(String random);

    /**
     * 登录
     * @param req
     * @param imgCode 验证码
     * @return
     */
    BaseCommonResponse<String> login(BaseCommonRequest<MngUserRo>  req, String imgCode);
}
