package Q3_using_ProgrammaticTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionMain {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
 //accountService.Add("ankit",6000);

       // accountService.Get("anky");
       // accountService.Update("ankit",5500);
        //accountService.Delete("ankit");
    accountService.Transferamount("anky",100,"vikesh");
    }
}