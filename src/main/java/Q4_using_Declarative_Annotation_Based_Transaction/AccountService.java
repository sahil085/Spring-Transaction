package Q4_using_Declarative_Annotation_Based_Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class AccountService {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Transactional
    public void Transferamount(String fromuser,int amt,String touser)
    {

      try {
          String query = "update user_account set amount=amount-? where username=?";
          jdbcTemplate.update(query, new Object[]{amt, fromuser});
      }
      catch (Exception ex){

      }

      updateAmount(touser,amt);
        System.out.println("amount transfered");
      }

@Transactional
public void updateAmount(String un,int recievedamt){
        try{
            String query="update user_account set amount=amount+? where username=?";
            jdbcTemplate.update(query,new Object[]{recievedamt,un});
        }
        catch (Exception ex){

        }

    System.out.println("amount recieved");
}

    public void Add(String un,int amt){

        String query="insert into user_account (username,amount) values(?,?)";
jdbcTemplate.update(query,new Object[]{un,amt});
    System.out.println("data stored");

    }



    public void Get(String un){
        TransactionDefinition definition=new DefaultTransactionDefinition();
        TransactionStatus status=transactionManager.getTransaction(definition);
        try {
            String q = "SELECT amount from user_account where username=?";
            String result = (String) jdbcTemplate.queryForObject(q, new Object[]{un}, String.class);
            System.out.println("data got : " + result);
        }
        catch (Exception ex){
            transactionManager.rollback(status);
        }
        System.out.println(status);
        transactionManager.commit(status);
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
