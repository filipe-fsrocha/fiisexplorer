package br.com.fsrocha.fiisexplorer.configuration.bean;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Configuration
public class ModelMapperConfiguration {

    @Bean
    public CustomModelMapper modelMapper() {
        CustomModelMapper modelMapper = new CustomModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        return modelMapper;
    }

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static class CustomModelMapper extends ModelMapper {
        Set<Class<?>> allowedNullSources = new HashSet<>();

        @Override
        public <D> D map(Object source, Class<D> destinationType) {
            if (source == null && allowedNullSources.contains(destinationType)) {
                source = new Object();
            }
            return super.map(Objects.requireNonNull(source), destinationType);
        }

        public void allowNullSources(Class<?> destinationType) {
            allowedNullSources.add(destinationType);
        }
    }
}
