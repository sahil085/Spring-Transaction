package Q6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransferAmoutLogs {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTransferLogs(String sender,String reciever,int transferedAmt){
            String query="insert into account_transaction (sender,reciever,tramount) values(?,?)"; // here i removed 1 parameter ? to throw runtime exception
            jdbcTemplate.update(query,new Object[]{sender,reciever,transferedAmt});



    }

}
