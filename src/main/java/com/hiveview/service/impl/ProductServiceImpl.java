package com.hiveview.service.impl;

import com.hiveview.dao.IProductDao;
import com.hiveview.model.Product;
import com.hiveview.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }
}
