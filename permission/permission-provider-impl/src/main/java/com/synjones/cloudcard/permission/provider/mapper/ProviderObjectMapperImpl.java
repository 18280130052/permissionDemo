package com.synjones.cloudcard.permission.provider.mapper;

import com.synjones.cloudcard.permission.provider.models.MngPageInfoRo;
import com.synjones.common.share.request.BasePageRequest;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProviderObjectMapperImpl implements ProviderObjectMapper {
	
	private MapperFacade mapper;

	
	public 	ProviderObjectMapperImpl( ){
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		
	
		mapperFactory.classMap(MngPageInfoRo.class, BasePageRequest.class).byDefault().register();
		
		
		
		mapper = mapperFactory.getMapperFacade();
		
	}
	
	@Override
	public <A,B> B mapper( A arg0, Class<B> arg1 ){
		
		if( null == arg0 )
			return null;
		
		return mapper.map( arg0, arg1 );
	}
	
	
    @Override
    public <A, B> List<B> mapper(List<A> sourceList, Class<B> clazz) {
        if (sourceList == null) {
            return null;
        }

        return mapper.mapAsList(sourceList, clazz);
    }
    
    @Override
    public <S, D> void mapper(S sourceObject, D destinationObject){
        if (sourceObject == null) {
            return;
        }
        
        mapper.map(sourceObject, destinationObject);
    }

}
