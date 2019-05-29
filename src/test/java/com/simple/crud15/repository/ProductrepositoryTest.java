package com.simple.crud15.repository;

import com.simple.crud15.CrudeverisApplication;
import com.simple.crud15.model.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrudeverisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductrepositoryTest {

    @Autowired
    private Productrepository repository;

    private PodamFactory factory ;

    @Before
    public void setUp() throws Exception {
        factory = new PodamFactoryImpl();

    }

    @Test
    public void testProductRepositoryNotNUll() {
        Assert.assertNotNull(repository);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testDelete()
    {


        Product pojo = factory.manufacturePojo(Product.class);
        pojo= this.repository.save(pojo);
        Long iD=pojo.getId();
        this.repository.delete(pojo);
        Assert.assertNull(this.repository.findOne(iD));

    }

    @Test
    public void testSave()
    {
        Product pojo = factory.manufacturePojo(Product.class);

        pojo= this.repository.save(pojo);

        Assert.assertNotNull(this.repository.save(pojo));

    }

    @Test
    public void testFindAll()
    {
        @SuppressWarnings("unchecked")
        List<Product> products = this.factory.manufacturePojo(ArrayList.class, Product.class);
        this.repository.save(products);
        Assert.assertEquals( products.size() , ((Collection<?>) this.repository.findAll()).size() );



    }
}