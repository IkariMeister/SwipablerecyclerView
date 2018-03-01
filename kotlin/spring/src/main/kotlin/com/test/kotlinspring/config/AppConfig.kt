package com.test.kotlinspring.config


/**
 * Created by jcgarcia on 31/05/2017.
 */
@Configuration
@ComponentScan(value = "es.renfe.brc09esacgadbatch", excludeFilters = {
    @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class)
})
class AppConfig {
}