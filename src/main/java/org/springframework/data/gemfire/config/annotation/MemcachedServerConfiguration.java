/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.springframework.data.gemfire.config.annotation;

import java.util.Map;
import java.util.Properties;

import org.springframework.data.gemfire.config.annotation.support.EmbeddedServiceConfigurationSupport;

/**
 * The MemcachedServerConfiguration class is a Spring {@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
 * that applies additional GemFire configuration by way of GemFire System properties to configure
 * an embedded Memcached server.
 *
 * @author John Blum
 * @see org.springframework.data.gemfire.config.annotation.support.EmbeddedServiceConfigurationSupport
 * @since 1.9.0
 */
public class MemcachedServerConfiguration extends EmbeddedServiceConfigurationSupport {

	@Override
	protected Class getAnnotationType() {
		return EnableMemcachedServer.class;
	}

	@Override
	protected Properties toGemFireProperties(Map<String, Object> annotationAttributes) {
		Properties gemfireProperties = new Properties();

		setProperty(gemfireProperties, "memcached-port", annotationAttributes.get("port"));
		setProperty(gemfireProperties, "memcached-protocol", annotationAttributes.get("protocol"));

		return gemfireProperties;
	}
}
