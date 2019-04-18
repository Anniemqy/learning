package com.hiveview.dao;

import com.hiveview.model.Product;

import java.util.List;

/**
 * @author huxunqiang created on 2019/4/15
 */
public interface IProductDao {
    List<Product> getAllProduct();
}
