package Q1_and_Q2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountService {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

@Transactional
    public void Add(String un,int amt){
        String query="insert into user_account (username,amount) values(?,?)";
jdbcTemplate.update(query,new Object[]{un,amt});
    System.out.println("data stored");

    }


    @Transactional
    public void Get(String un){
        String q="SELECT amount from user_account where username=?";
        String result=(String) jdbcTemplate.queryForObject(q,new Object[]{un},String.class);
        System.out.println("data got : "+result);
    }

    @Transactional
    public void Update(String un,int amt){
        String query="update user_account SET amount=? where username=?";
        jdbcTemplate.update(query,new Object[]{amt,un});
        System.out.println("data is updated");

    }


    @Transactional
    public void Delete(String un){
        String query="delete from user_account where username=?";
        jdbcTemplate.update(query,new Object[]{un});
        System.out.println("data deleted");

    }

}
