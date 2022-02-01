package componentscan;

import org.springframework.stereotype.Component;

@Component
public class ComponentJdbcConnection {
    public ComponentJdbcConnection() {
        System.out.println("ComponentJDBC Connection.");
    }

}
