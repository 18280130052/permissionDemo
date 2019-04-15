package com.synjones.cloudcard.permission.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.synjones.cloudcard.permission.core.service.PermissionService;
import com.synjones.cloudcard.permission.core.service.mapper.CoreObjectMapper;
import com.synjones.cloudcard.permission.core.service.utils.JWTUtil;
import com.synjones.cloudcard.permission.infra.dao.MngUserDao;
import com.synjones.cloudcard.permission.infra.entity.MngUserEntity;
import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MngUserDao mngUserDao;
    @Autowired
    private CoreObjectMapper coreMapper;

    @Override
    public List<MngResourceRo> menuTree(MngUserRo UserRo) {
        return null;
    }

    @Override
    public PageInfo<MngUserRo> listUser(MngPageInfoRo info, MngUserRo userRo, CommonArgs args) {
        Page<MngUserEntity> page = new Page<>(info.getPageNo(), info.getPageSize());
        //PageHelper.startPage(info.getPageNo(), info.getPageSize());
        MngUserEntity userEntity = coreMapper.mapper(userRo, MngUserEntity.class);
        List<MngUserEntity> listUser = mngUserDao.listUser(page, userEntity);
        PageInfo<MngUserEntity> pageInfo = new PageInfo<>(listUser);
        pageInfo.setTotal(page.getTotal());

        System.out.println("pageMapper数目---"+page.getTotal());

        return coreMapper.mapper(pageInfo, MngUserRo.class);
    }

    @Override
    public void addUser(MngUserRo userRo, CommonArgs args) {

    }

    @Override
    public void editUser(MngUserRo userRo, CommonArgs args) {

    }

    @Override
    public void delUser(MngUserRo userRo) {

    }

    @Override
    public void updateStatus(MngUserRo req) {

    }

    @Override
    public List<MngRoleRo> roleTreeForUser(MngUserRo userRo, String buttonCode) {
        return null;
    }

    @Override
    public PageInfo<MngRoleRo> listRole(MngPageInfoRo info, MngRoleRo roleRo) {
        return null;
    }

    @Override
    public void addRole(MngRoleRo roleRo) {

    }

    @Override
    public void editRole(MngRoleRo roleRo) {

    }

    @Override
    public void delRole(MngRoleRo roleRo) {

    }

    @Override
    public List<MngRoleRo> roleTreeForRole(MngRoleRo roleRo, String buttonCode) {
        return null;
    }

    @Override
    public List<MngResourceRo> resourceTree(MngRoleRo roleRo, String roleType) {
        return null;
    }

    @Override
    public List<MngOperLogRo> listLog(MngOperLogRo log) {
        return null;
    }

    @Override
    public void addLog(MngOperLogRo log) {

    }

    /**
     * 身份认证
     * @param token JWT令牌
     * @param username 用户名
     * @return
     */
    @Override
    public Boolean authentication(String token, String username) {
        MngUserEntity entity = new MngUserEntity();
        entity.setUserName(username);
        MngUserEntity mngUserEntity = mngUserDao.selectOne(entity);
        //用户名不存在返回false
        if (null == mngUserEntity)
            return false;
        boolean verify = JWTUtil.verify(token, username, mngUserEntity.getPassword());
        return verify;
    }

    @Override
    public Boolean areaAuthentication(CommonArgs args) {
        return null;
    }

    @Override
    public PageInfo<MngResourceRo> listThirdMenu(MngPageInfoRo infoRo, MngResourceRo resourceRo) {
        return null;
    }

    @Override
    public void addThirdMenu(MngResourceRo resourceRo) {

    }

    @Override
    public void editThirdMenu(MngResourceRo resourceRo) {

    }

    @Override
    public void delThirdMenu(MngResourceRo resourceRo) {

    }

    @Override
    public void verify(String random) {

    }

    @Override
    public String login(MngUserRo userRo, String imgCode) {
        //Subject subject = SecurityUtils.getSubject();

        List<MngUserEntity> list = mngUserDao.selectList(new EntityWrapper<MngUserEntity>().eq("user_name", userRo.getUserName()));
        //用户不存在
        if (list.isEmpty()){
            return null;
        }
        MngUserEntity userEntity = list.get(0);
        String password = userEntity.getPassword();
        //密码错误
        if (!password.equals(userRo.getPassword())){
            return null;
        }
        String token = JWTUtil.createToken(userEntity.getUserName(), password);
        return token;
    }
}
