package com.simple.crud15.repository;

import com.simple.crud15.CrudeverisApplication;
import com.simple.crud15.model.Cart;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.charset.Charset.forName;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrudeverisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartRepositoryTest {

    @Autowired
    private CartRepository repository;



    private EasyRandom factory ;

    @Before
    public void setUp() throws Exception {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(forName("UTF-8"))

                .stringLengthRange(5, 50)

                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        factory = new EasyRandom(parameters);


    }

    @Test
    public void testRepositoryNotNUll() {
        Assert.assertNotNull(repository);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testDelete()
    {


        Cart pojo = factory.nextObject(Cart.class);
        pojo.setId(1L);
        pojo.setItems(null);
        pojo= this.repository.save(pojo);
        Long iD=pojo.getId();
        this.repository.delete(pojo);
        Assert.assertNull(this.repository.findOne(iD));

    }

    @Test
    public void testSave()

    {


        Cart pojo =factory.nextObject(Cart.class);
        pojo.setId(null);
        pojo.setItems(
        pojo.getItems().stream().map( item -> {
            item.setId(null);
            return item;
        }).collect( Collectors.toSet())
        );



        //
        // pojo.setItems(IntStream.range(1,10).limit(10).mapToObj( e->   factory.manufacturePojoWithFullData(Items.class)  ).collect(Collectors.toSet()));


        pojo= this.repository.save(pojo);


        Assert.assertNotNull(this.repository.save(pojo));

    }

    @Test
    public void testFindAll()
    {

        List<Cart> carts=IntStream.range(1,10).mapToObj( e->
                {
                    Cart cart1 = this.factory.nextObject(Cart.class);
                    cart1.setId(null);

                    cart1.getItems().forEach( myitem -> {  System.out.println("-<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+myitem);});

                    cart1.getItems().stream().map( i-> { i.setId(null); i.setCart(cart1); ;return i; }).collect(  Collectors.toSet());
                    return cart1;
                }

                ).collect(Collectors.toList());
        this.repository.save(carts);

        Assert.assertEquals( carts.size() , ((Collection<?>) this.repository.findAll()).size() );

        this.repository.findAll().forEach( cart -> {  System.out.println("->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cart);});




    }
}