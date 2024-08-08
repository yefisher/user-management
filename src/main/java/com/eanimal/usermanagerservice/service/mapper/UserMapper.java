package com.eanimal.usermanagerservice.service.mapper;

import com.eanimal.usermanagerservice.api.request.UserRequest;
import com.eanimal.usermanagerservice.domain.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
  @Mapping(target = "creationDate", expression = "java(java.time.Instant.now())")
  @Mapping(target = "encodedPassword", ignore = true)
  @Mapping(target = "lastPasswordUpdateDate", ignore = true)
  @Mapping(target = "lastUpdateDate", ignore = true)
  @Mapping(target = "activityLastDate", ignore = true)
  User toEntity(UserRequest request);
}
