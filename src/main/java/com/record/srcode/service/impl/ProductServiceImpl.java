package com.record.srcode.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.record.srcode.mapper.ProductMapper;
import com.record.srcode.po.Product;
import com.record.srcode.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author lifez
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2022-08-05 22:08:08
 */
@DS("slave1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

}




