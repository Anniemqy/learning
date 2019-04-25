package com.hiveview.dao;

import com.hiveview.model.Product;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

public interface IProductDao {
    List<Product> getAllProduct();
}
