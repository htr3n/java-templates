package au.com.infomedix.charting.sago.adapter.persistence;

import au.com.infomedix.charting.sago.adapter.persistence.entity.CallingCriteriaEntity;
import au.com.infomedix.charting.sago.adapter.persistence.entity.CriteriaColour;
import au.com.infomedix.charting.sago.adapter.persistence.entity.CriteriaDefinitionEntity;
import au.com.infomedix.charting.sago.model.CallingCriteria;
import au.com.infomedix.charting.sago.model.CriteriaDefinition;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.WARN,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    disableSubMappingMethodsGeneration = true)
public interface ChartMapper {
  ChartMapper INSTANCE = Mappers.getMapper(ChartMapper.class);

  CallingCriteria map(CallingCriteriaEntity entity);

  CriteriaDefinition map(CriteriaDefinitionEntity entity);

  default String map(CriteriaColour value) {
    if (value != null) {
      return value.getRgb();
    }
    return null;
  }

  default Map<String, CriteriaDefinition> map(List<CriteriaDefinitionEntity> entities) {
    if (entities != null && !entities.isEmpty()) {
      return entities.stream()
          .collect(Collectors.toMap(CriteriaDefinitionEntity::getName, this::map));
    }
    return Collections.emptyMap();
  }

  default Map<String, CallingCriteria> createRoot(List<CallingCriteriaEntity> callingCriteria) {
    if (callingCriteria != null) {}
    return Collections.emptyMap();
  }
}
