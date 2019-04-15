package com.synjones.cloudcard.permission.core.service.mapper;

import com.github.pagehelper.PageInfo;
import com.synjones.cloudcard.permission.infra.entity.MngOperLogEntity;
import com.synjones.cloudcard.permission.infra.entity.MngResourceEntity;
import com.synjones.cloudcard.permission.infra.entity.MngRoleEntity;
import com.synjones.cloudcard.permission.infra.entity.MngUserEntity;
import com.synjones.cloudcard.permission.provider.models.MngOperLogRo;
import com.synjones.cloudcard.permission.provider.models.MngResourceRo;
import com.synjones.cloudcard.permission.provider.models.MngRoleRo;
import com.synjones.cloudcard.permission.provider.models.MngUserRo;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.util.List;


@Component
public class CoreObjectMapperImpl implements CoreObjectMapper {

	private MapperFacade mapper;

	public CoreObjectMapperImpl() {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap(MngUserEntity.class, MngUserRo.class).byDefault().register();
		
		mapperFactory.classMap(MngRoleEntity.class, MngRoleRo.class).byDefault().register();

		mapperFactory.classMap(MngResourceEntity.class, MngResourceRo.class).byDefault().register();
		
		mapperFactory.classMap(MngOperLogEntity.class, MngOperLogRo.class).byDefault().register();
		
		
		

		mapper = mapperFactory.getMapperFacade();

	}

	@Override
	public <A, B> B mapper(A arg0, Class<B> arg1) {

		if (null == arg0)
			return null;

		return mapper.map(arg0, arg1);
	}

	@Override
	public <A, B> List<B> mapper(List<A> sourceList, Class<B> clazz) {
		if (sourceList == null) {
			return null;
		}

		return mapper.mapAsList(sourceList, clazz);
	}

	@Override
	public <S, D> void mapper(S sourceObject, D destinationObject) {
		if (sourceObject == null) {
			return;
		}

		mapper.map(sourceObject, destinationObject);
	}

	@Override
	public <A, B> PageInfo<B> mapper(PageInfo<A> sourceList, Class<B> clazz) {
		if (sourceList == null) {
			return null;
		}

		PageInfo<B> info = new PageInfo<B>();
		mapper.map(sourceList, info);

		if (null != sourceList.getList())
			info.setList(mapper.mapAsList(sourceList.getList(), clazz));

		return info;
	}

	@Override
	public <S, D> void mapperWithNotNull(S sourceObject, D destinationObject) {

		Field[] sourceFields = sourceObject.getClass().getDeclaredFields();
		Field[] destinationFields = destinationObject.getClass().getDeclaredFields();
		for (Field sourceField : sourceFields) {
			for (Field destinationField : destinationFields) {
				if (sourceField.getName().equals(destinationField.getName())) {
					// Object
					// val=getFieldValueByName(sourceField.getName(),sourceObject);

					try {
						sourceField.setAccessible(true);
						destinationField.setAccessible(true);
						Object val = sourceField.get(sourceObject);
						if (null != val) {
							destinationField.set(destinationObject, val);
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

					break;
				}
			}

		}

	}

}
