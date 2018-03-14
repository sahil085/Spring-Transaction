package Q6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionMain {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
 //accountService.Add("ankit",6000);

        //accountService.Get("anky");
       // accountService.Update("ankit",5500);
        //accountService.Delete("ankit");
    accountService.Transferamount("peter",100,"anky");
    }
}