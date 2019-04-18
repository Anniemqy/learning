package com.hiveview.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.hiveview.model.Product;
import com.hiveview.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huxunqiang created on 2019/4/15
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ResponseBody
    @RequestMapping("/getAllProduct")
    public Map<String,Object> getAllProduct(){
        Map<String,Object> result = new HashMap<>();
        try {
            List<Product> products = productService.getAllProduct();
            result.put("data",products);
            Maps.newHashMap();
            Lists.newArrayList();
            Sets.newHashSet();

            StringUtils.isNotEmpty("");
            NumberUtils.isDigits("");

            Product b = JSON.parseObject("", Product.class);
            String c = JSON.toJSONString(b);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
