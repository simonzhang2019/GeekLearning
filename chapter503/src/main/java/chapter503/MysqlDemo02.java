package chapter503;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MysqlDemo02 {

    /**
     * Spring Boot 2.x 默认使用了Hikari 连接池
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertData() {
        int count = jdbcTemplate.update("insert into class01 (id, name) values (1, 'student01')");
        System.out.println("insert counts = " + count);
        return count;
    }

    public Map<String, Object> searchFirstData() {
        List<Map<String, Object>> datas = jdbcTemplate.queryForList("select * from class01 where id = 2");
        for (Map<String, Object> map : datas) {
            System.out.println(map);
        }
        return datas.get(0);
    }

    public int updateData() {
        int count = jdbcTemplate.update("update class01 set name = 'student02' where id = 3");
        System.out.println("update counts = " + count);
        return count;
    }
}
