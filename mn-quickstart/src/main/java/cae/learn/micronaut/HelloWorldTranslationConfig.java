package cae.learn.micronaut;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {

    @NotBlank // no empty strings allowed
    String getDe();

    @NotBlank
    String getEn();
}
