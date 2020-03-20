package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ImageHolder;
import com.zjm.schoolmarket.dto.ProductExecution;
import com.zjm.schoolmarket.entity.Product;
import com.zjm.schoolmarket.exceptions.ProductOperationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    /**
     * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态，店铺Id,商品类别
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
//    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    /**
     * 通过商品Id查询唯一的商品信息
     *
     * @param productId
     * @return
     */
//    Product getProductById(long productId);

    /**
     * 添加商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
            throws ProductOperationException;

    @Transactional
            // 1.若缩略图参数有值，则处理缩略图，
            // 若原先存在缩略图则先删除再添加新图，之后获取缩略图相对路径并赋值给product
            // 2.若商品详情图列表参数有值，对商品详情图片列表进行同样的操作
            // 3.将tb_product_img下面的该商品原先的商品详情图记录全部清除
            // 4.更新tb_product_img以及tb_product的信息
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
                                   List<ImageHolder> productImgHolderList) throws ProductOperationException;

    /**
     * 修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgs
     * @return
     * @throws ProductOperationException
     */
//    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
//            throws ProductOperationException;
}
