package step2;

import com.study.framework.core.helper.DatabaseHelper;
import com.study.app.step2.model.Customer;
import com.study.app.step2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackeyChen on 2016/9/20.
 */
public class CustomerServiceTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() {
        String file = "sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);
    }

    @Test
    public void testInit() {
        init();
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> fileMap = new HashMap<>();
        fileMap.put("name", "customer100");
        fileMap.put("contact", "John");
        fileMap.put("telephone", "13512345678");
        boolean result = customerService.createCustomer(fileMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        long id = 1;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Eric");
        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomer() throws Exception {
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
