package com.bamdule.memorymap.config;

import com.bamdule.memorymap.db.service.PropertyService;
import com.bamdule.memorymap.model.entity.Property;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MW
 */
@Component
public class ServerConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private PropertyService propertyService;
    private Map<String, String> config = new HashMap<>();

//    @Value("${server.type}")
//    private String serverType;
    @PostConstruct
    public void staticPropertyBean() {
        servletContext.setAttribute("contextPath", servletContext.getContextPath());

        List<Property> properties = propertyService.getListProperty("server");

        properties.forEach(property -> {
            logger.info("[CONFIG] {} : {}", property.getName(), property.getValue());
            config.put(property.getName(), property.getValue());
        });

        logger.info("[CONFIG] ServerConfig init completed");
    }

    public String getConfig(String name) {
        return config.get(name);
    }

    public Map<String, String> getConfig() {
        return config;
    }
}
