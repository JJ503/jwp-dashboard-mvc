package reflection;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.annotation.Controller;
import reflection.annotation.Repository;
import reflection.annotation.Service;

import java.util.Set;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("reflection.examples");

        // TODO 클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다.
        reflections.getTypesAnnotatedWith(Controller.class)
                   .forEach(clazz -> {
                       final String name = clazz.getSimpleName();
                       log.info("Controller 클래스명 : {}", name);
                   });
        reflections.getTypesAnnotatedWith(Service.class)
                   .forEach(clazz -> {
                       final String name = clazz.getSimpleName();
                       log.info("Service 클래스명 : {}", name);
                   });
        reflections.getTypesAnnotatedWith(Repository.class)
                   .forEach(clazz -> {
                       final String name = clazz.getSimpleName();
                       log.info("Repository 클래스명 : {}", name);
                   });
    }
}
