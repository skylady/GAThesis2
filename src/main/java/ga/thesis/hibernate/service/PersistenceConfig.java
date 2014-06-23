package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ga.thesis.hibernate")
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan(basePackages = {"ga.thesis.hibernate", "ga.thesis.gui.table"})
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AbsenceMatrixService absenceMatrixService;

    @Autowired
    private AbsencePeriodService absencePeriodService;

    @Autowired
    private AuditoryService auditoryService;

    @Autowired
    private StudentListService studentListService;

    @Autowired
    private GroupListService groupListService;

    @Autowired
    private PeriodService periodService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupCodeService groupCodeService;


    public static void main(String[] args) {
        ApplicationContext applicationContext = runService(args);
        PersistenceConfig bean = applicationContext.getBean(PersistenceConfig.class);
        bean.run(args);
    }

    public static ApplicationContext runService(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PersistenceConfig.class, args);
        return run;
    }

    private static PersistenceConfig getContext() {
        ApplicationContext applicationContext = runService(new String [] {});
        PersistenceConfig bean = applicationContext.getBean(PersistenceConfig.class);
        return bean;
    }

    @Bean
    public DataSource getDataSource() {
        Class driverClass = environment.getPropertyAsClass("jdbc.driverClassName", Driver.class);

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setUrl(getProperty("jdbc.url"));
        dataSource.setUsername(getProperty("jdbc.user"));
        dataSource.setPassword(getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ga.thesis.hibernate");
        factory.setDataSource(getDataSource());
        factory.setJpaProperties(getHibernateProperties());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    public String getProperty(String name) {
        return environment.getProperty(name);
    }

    public Properties getHibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
                setProperty("hibernate.connection.characterEncoding", environment.getProperty("hibernate.connection.characterEncoding"));
                setProperty("hibernate.connection.useUnicode", environment.getProperty("hibernate.connection.useUnicode"));
                setProperty("hibernate.connection.charSet", environment.getProperty("hibernate.connection.charSet"));
            }
        };
    }

    public void run(String... strings) {
        Teacher teacher = new Teacher();
        teacher.setName("del");
        AbsenceMatrix absenceMatrix = new AbsenceMatrix();
        absenceMatrix.setAbsenceMatrixName("Maтриця Олецького");
        absenceMatrixService.create(absenceMatrix);
        teacher.setIdAbsenceMatrix(absenceMatrix);
        teacherService.create(teacher);

        //new-------------------------------

        Auditory auditory = new Auditory();
        auditory.setAuditoryNumber("223");
        auditory.setAuditorySize(40);
        auditory.setAuditoryType("lect");
        auditoryService.create(auditory);

        //groupList
        GroupList groupList = new GroupList();
        groupList.setGroupName("ГА1");
        groupListService.create(groupList);

        //studentList

        StudentList studentList = new StudentList();
        studentList.setStudentName("Pasichnyk");
        studentList.setIdGroupList(groupList);
        studentListService.create(studentList);

        //period
        Period period = new Period();
        period.setDayOfTheWeek("Wednesday");
        period.setPeriod(1);
        periodService.create(period);

        //absencePeriod
        AbsencePeriod absencePeriod = new AbsencePeriod();
        absencePeriod.setIdAbsenceMatrix(absenceMatrix);
        absencePeriod.setIdPeriod(period);
        absencePeriodService.create(absencePeriod);

        //GroupCode
        GroupCode groupCode = new GroupCode();

        groupCode.setSubject("ГА");
        groupCode.setSubjectType("л");
        groupCode.setGroupType("тип 1");
        groupCode.setWeekNumbers("1-14");
        groupCode.setIdGroupList(groupList);
        groupCode.setIdGroupTeacher(teacher);
        groupCode.setGroupSize(10);
        groupCodeService.create(groupCode);

        //Group
        Group group = new Group();
        group.setCourse("gggg2");
        group.setGroupNumber(1);
        group.setIdGroupCode(groupCode);
        groupService.create(group);
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public AbsenceMatrixService getAbsenceMatrixService() {
        return absenceMatrixService;
    }

    public AbsencePeriodService getAbsencePeriodService() {
        return absencePeriodService;
    }

    public AuditoryService getAuditoryService() {
        return auditoryService;
    }

    public StudentListService getStudentListService() {
        return studentListService;
    }

    public GroupListService getGroupListService() {
        return groupListService;
    }

    public PeriodService getPeriodService() {
        return periodService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public GroupCodeService getGroupCodeService() {
        return groupCodeService;
    }

    public static PersistenceConfig getInstance() {
        return PersistenceUtils.getInstance().getConfig();
    }

    public static class PersistenceUtils {
        private final PersistenceConfig config;

        private PersistenceUtils() {
            config = PersistenceConfig.getContext();
        }

        public PersistenceConfig getConfig() {
            return config;
        }

        public static class Holder {
            private static PersistenceUtils persistenceUtils = new PersistenceUtils();
        }

        public static PersistenceUtils getInstance() {
            return Holder.persistenceUtils;
        }
    }
}
