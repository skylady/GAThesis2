package ga.thesis.hibernate.config;

import ga.thesis.hibernate.entities.Teacher;
import ga.thesis.hibernate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceConfig.class)
@ComponentScan(basePackages = "ga.thesis.hibernate.service, ga.thesis.hibernate.config")
public class Application implements CommandLineRunner {

    @Autowired
    private TeacherService teacherService;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String s:beanDefinitionNames) {
            System.out.println(s);
        }


    }

    @Override
    public void run(String... strings) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("del");
        teacherService.create(teacher);
    }
}
