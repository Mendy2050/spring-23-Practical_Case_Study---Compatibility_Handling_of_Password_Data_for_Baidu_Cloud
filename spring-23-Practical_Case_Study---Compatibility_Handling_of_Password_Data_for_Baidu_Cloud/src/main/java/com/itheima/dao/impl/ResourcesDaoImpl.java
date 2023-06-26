package com.itheima.dao.impl;

import com.itheima.dao.ResourcesDao;
import org.springframework.stereotype.Repository;


/**
 * @author Mendy
 * @create 2023-06-26 14:27
 */
@Repository
public class ResourcesDaoImpl implements ResourcesDao {
    public boolean readResources(String url, String password) {

        System.out.println(password.length());

        //Simulate the verification
        return password.equals("root");
    }
}

