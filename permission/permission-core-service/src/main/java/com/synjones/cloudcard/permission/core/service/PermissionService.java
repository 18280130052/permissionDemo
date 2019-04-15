package com.synjones.cloudcard.permission.core.service;

import com.github.pagehelper.PageInfo;
import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.models.*;
import java.util.List;

public interface PermissionService {
    /**
     * 根据操作员角色查询菜单树(主页左侧菜单树)
     * @param UserRo 操作员信息
     * @return 资源树的数据集合
     */
    List<MngResourceRo> menuTree(MngUserRo UserRo);

    /**
     * 多条件分页查询操作员列表
     * @param info   分页信息
     * @param userRo 操作员查询条件
     * @param args   分区信息
     * @return
     */
    PageInfo<MngUserRo> listUser(MngPageInfoRo info, MngUserRo userRo, CommonArgs args);

    /**
     * 新增操作员
     * @param userRo 操作员信息
     * @param args
     */
    void addUser(MngUserRo userRo, CommonArgs args);

    /**
     * 修改操作员
     * @param userRo
     * @param args
     */
    void editUser(MngUserRo userRo, CommonArgs args);

    /**
     * 删除操作员
     * @param userRo
     */
    void delUser(MngUserRo userRo);

    /**
     * 修改操作员状态
     * @param req
     */
    void updateStatus(MngUserRo req);

    /**
     * 根据操作员及按钮值查询角色树
     * @param userRo
     * @param buttonCode
     * @return
     */
    List<MngRoleRo> roleTreeForUser(MngUserRo userRo, String buttonCode);

    /**
     * 根据角色及operCode值分页查询对应角色列表
     * @param info 分页
     * @param roleRo 角色信息
     * @return
     */
    PageInfo<MngRoleRo> listRole(MngPageInfoRo info, MngRoleRo roleRo);

    /**
     * 新增角色
     * @param roleRo
     */
    void addRole(MngRoleRo roleRo);

    /**
     * 修改角色
     * @param roleRo
     */
    void editRole(MngRoleRo roleRo);

    /**
     * 删除角色
     * @param roleRo
     */
    void delRole(MngRoleRo roleRo);

    /**
     * 根据角色及按钮值查询对应的角色树(角色页面的角色树)
     * @param roleRo
     * @param buttonCode
     * @return
     */
    List<MngRoleRo> roleTreeForRole(MngRoleRo roleRo, String buttonCode);

    /**
     * 根据角色及类型查询资源树(角色页面的权限树)
     * @param roleRo
     * @param roleType
     * @return
     */
    List<MngResourceRo> resourceTree(MngRoleRo roleRo,String roleType);

    /**
     * 查询日志列表
     * @param log 查询条件
     * @return
     */
    List<MngOperLogRo> listLog(MngOperLogRo log);

    /**
     * 新增日志记录
     * @param log
     * @return
     */
    void addLog(MngOperLogRo log);

    /**
     * 身份认证
     * @param token JWT令牌
     * @param username 用户名
     * @return
     */
    Boolean authentication(String token, String username);

    /**
     * 操作越权验证
     * @param args
     * @return
     */
    Boolean areaAuthentication(CommonArgs args);

    /**
     * 多条件查询第三方菜单列表
     * @param infoRo 分页
     * @param resourceRo 查询条件
     * @return
     */
    PageInfo<MngResourceRo> listThirdMenu(MngPageInfoRo infoRo, MngResourceRo  resourceRo);

    /**
     * 新增第三方菜单
     * @param resourceRo
     * @return
     */
    void addThirdMenu(MngResourceRo resourceRo);

    /**
     * 修改第三方菜单
     * @param resourceRo
     * @return
     */
    void editThirdMenu(MngResourceRo resourceRo);

    /**
     * 删除第三方菜单
     * @param resourceRo
     * @return
     */
    void delThirdMenu(MngResourceRo resourceRo);

    /**
     * 生成验证码
     * @param random
     */
    void verify(String random);

    /**
     * 登录
     * @param userRo 登录信息
     * @param imgCode 验证码
     * @return
     */
    String login(MngUserRo  userRo, String imgCode);


}
