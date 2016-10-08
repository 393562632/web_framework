package com.study.app.step3.service;

import com.study.app.step3.model.Customer;
import com.study.framework.core.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by jackeyChen on 2016/9/20.
 */
public class CustomerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);


    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取用户信息
     *
     * @param keyWord
     * @return
     */
    public Customer getCustomer(Long id) {
        String sql = "select * from customer where id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     *
     * @param id
     * @param fileMap
     * @return
     */
    public Boolean createCustomer(Map<String, Object> fileMap) {
        return DatabaseHelper.insertEntity(Customer.class, fileMap);
    }

    public Boolean updateCustomer(long id, Map<String, Object> fileMap) {
        return DatabaseHelper.updateEntity(Customer.class, fileMap, id);
    }

    /**
     * 删除客户
     *
     * @return
     */
    public Boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);

    }
}
