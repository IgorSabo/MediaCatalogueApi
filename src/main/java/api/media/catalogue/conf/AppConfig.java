package api.media.catalogue.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Gile on 5/29/2017.
 */
@Configuration
@ComponentScan(basePackages = {"api.media.catalogue.resource",
        "api.media.catalogue.service", "api.media.catalogue.repository"})
public class AppConfig {
}
