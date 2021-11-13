package dynamic.database;

import dynamic.database.bean.Cost;
import dynamic.database.service.CostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dynamic-mybatis.xml");

        // 本练习为参照网上资料模仿而成，还请谅解~
        Cost cost = new Cost();

        CostService costService = context.getBean(CostService.class);
        costService.insert(cost);
        costService.insert2(cost);

    }
}
