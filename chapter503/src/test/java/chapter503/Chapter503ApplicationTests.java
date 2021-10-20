package chapter503;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter503ApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	MysqlDemo02 MysqlDemo02;


	@Test
	public void insertTest() throws SQLException{
		int count = MysqlDemo02.insertData();
		Assert.assertTrue(count==1);
	}

	@Test
	public void selectTest() throws SQLException{
		Map<String, Object> map = MysqlDemo02.searchFirstData();
		System.out.println(map);
		Assert.assertTrue(map.get("name").equals("studentA"));
	}

	@Test
	public void updateTest() throws SQLException{
		int count = MysqlDemo02.updateData();
		Assert.assertTrue(count==1);
	}



}
