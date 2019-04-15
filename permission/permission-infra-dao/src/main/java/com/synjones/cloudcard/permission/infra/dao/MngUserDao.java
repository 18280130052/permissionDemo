package com.synjones.cloudcard.permission.infra.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.synjones.cloudcard.permission.infra.entity.MngUserEntity;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Old rookie
 * @since 2019-04-14
 */
public interface MngUserDao extends BaseMapper<MngUserEntity> {
    List<MngUserEntity> listUser(Page<MngUserEntity> page, MngUserEntity userEntity);
}
