package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.entity.Product;
import com.zjm.schoolmarket.entity.ProductCategory;
import com.zjm.schoolmarket.entity.ProductImg;
import com.zjm.schoolmarket.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;

	@Test
	public void testAInsertProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(3L);
		// 初始化三个商品实例并添加进shopId为1的店铺里，
		// 同时商品类别Id也为1
		Product product1 = new Product();
		product1.setProductName("测试1");
		product1.setProductDesc("测试Desc1");
		product1.setImgAddr("test1");
		product1.setPriority(1);
		product1.setEnableStatus(1);
		product1.setCreateTime(new Date());
		product1.setLastEditTime(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		Product product2 = new Product();
		product2.setProductName("测试2");
		product2.setProductDesc("测试Desc2");
		product2.setImgAddr("test2");
		product2.setPriority(2);
		product2.setEnableStatus(0);
		product2.setCreateTime(new Date());
		product2.setLastEditTime(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pc1);
		Product product3 = new Product();
		product3.setProductName("test3");
		product3.setProductDesc("测试Desc3");
		product3.setImgAddr("test3");
		product3.setPriority(3);
		product3.setEnableStatus(1);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pc1);
		// 判断添加是否成功
		int effectedNum = productDao.insertProduct(product1);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product2);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product3);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryProductList() throws Exception {
		Product productCondition = new Product();
		// 分页查询，预期返回三条结果
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		// 查询名称为测试的商品总数
		int count = productDao.queryProductCount(productCondition);
		assertEquals(12, count);
		// 使用商品名称模糊查询，预期返回两条结果
		productCondition.setProductName("测试");
		productList = productDao.queryProductList(productCondition, 0, 5);
		assertEquals(5, productList.size());
		count = productDao.queryProductCount(productCondition);
		assertEquals(6, count);
	}

	@Test
	public void testCQueryProductByProductId() throws Exception {
		long productId = 1;
		// 初始化两个商品详情图实例作为productId为1的商品下的详情图片
		// 批量插入到商品详情图表中
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("豆角炒肉");
		productImg1.setImgDesc("豆角炒肉图片");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setPriority(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		// 查询productId为1的商品信息并校验返回的详情图实例列表size是否为2
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
		// 删除新增的这两个商品详情图实例
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testDUpdateProduct() throws Exception {
		Product product = new Product();
		ProductCategory pc = new ProductCategory();
		Shop shop = new Shop();
		shop.setShopId(1L);
		pc.setProductCategoryId(1L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductName("白酒");
		product.setPromotionPrice("16");
		product.setNormalPrice("15");
		product.setLastEditTime(new Date());
		product.setProductCategory(pc);
		// 修改productId为1的商品的名称
		// 以及商品类别并校验影响的行数是否为
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testEUpdateProductCategoryToNull() {
		// 将productCategoryId为2的商品类别下面的商品的商品类别置为空
		int effectedNum = productDao.updateProductCategoryToNull(3L);
		assertEquals(10, effectedNum);
	}

	@Test
	public void testFDeleteShopAuthMap() throws Exception {
		// 清除掉insert方法添加的商品
		Product productCondition = new Product();
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		productCondition.setProductCategory(pc);
		// 通过输入productCategoryId为1去商品表中查出新增的三条测试数据
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		// 循环删除这三条数据
		for (Product p : productList) {
			int effectedNum = productDao.deleteProduct(p.getProductId(), 1);
			assertEquals(1, effectedNum);
		}
	}
}
