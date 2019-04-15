package com.synjones.cloudcard.permission.provider.mapper;

import java.util.List;

public interface ProviderObjectMapper {
	
	<A,B> B mapper(A src, Class<B> clazz);
	
	<A, B> List<B> mapper(List<A> sourceList, Class<B> clazz);
	
	<S, D> void mapper(S sourceObject, D destinationObject);
	
}
