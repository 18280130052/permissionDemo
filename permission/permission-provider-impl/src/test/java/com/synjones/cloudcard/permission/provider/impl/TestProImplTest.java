package com.synjones.cloudcard.permission.provider.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.synjones.cloudcard.permission.core.service.PermissionService;
import com.synjones.cloudcard.permission.infra.dao.MngUserDao;
import com.synjones.cloudcard.permission.infra.entity.MngUserEntity;
import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.facade.PermissionProvider;
import com.synjones.cloudcard.permission.provider.main.PermissionServerApplication;
import com.synjones.cloudcard.permission.provider.models.MngUserRo;
import com.synjones.common.share.request.BasePageRequest;
import com.synjones.common.share.response.BasePageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PermissionServerApplication.class)
public class TestProImplTest {

    @Autowired
    private PermissionProvider permissionProvider;
    @Autowired
    private PermissionService service;
    @Autowired
    private MngUserDao mngUserDao;
    @Test
    public void testPro() throws Exception{
        BasePageRequest<MngUserRo> pageRequest = new BasePageRequest<>();
        pageRequest.setPageNo(1);
        pageRequest.setPageSize(5);
        MngUserRo userRo = new MngUserRo();
        userRo.setUserName("admin001");
        pageRequest.setObj(userRo);
        CommonArgs args = new CommonArgs();
        BasePageResponse<MngUserRo> pageResponse = permissionProvider.listUser(pageRequest, args);
        System.out.println("数目--"+pageResponse.getTotal());
        pageResponse.getObjs().forEach(item-> System.out.println(item));
    }

    @Test
    public void testService() throws Exception{
        MngUserEntity userEntity = new MngUserEntity();
        userEntity.setUserName("admin001");
        List<MngUserEntity> list = mngUserDao.listUser(new Page<>(1,5 ),userEntity);
        list.forEach(item -> System.out.println(item));
//        MngUserEntity mngUserEntity = mngUserDao.selectOne(userEntity);
//        System.out.println(mngUserEntity);
    }

}