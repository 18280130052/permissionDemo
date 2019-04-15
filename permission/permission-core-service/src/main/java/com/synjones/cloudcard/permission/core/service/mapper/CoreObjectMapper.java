package com.synjones.cloudcard.permission.core.service.mapper;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CoreObjectMapper {

	<A, B> B mapper(A src, Class<B> clazz);

	<A, B> List<B> mapper(List<A> sourceList, Class<B> clazz);

	<S, D> void mapper(S sourceObject, D destinationObject);

	<S, D> void mapperWithNotNull(S sourceObject, D destinationObject);

	<A, B> PageInfo<B> mapper(PageInfo<A> sourceList, Class<B> clazz);
}
