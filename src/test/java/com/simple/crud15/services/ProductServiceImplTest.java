package com.simple.crud15.services;

import com.simple.crud15.CrudeverisApplication;
import com.simple.crud15.model.Product;
import com.simple.crud15.repository.Productrepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrudeverisApplication.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductServiceImplTest {

    @Mock
    Productrepository productrepository;
    Product product;
    @InjectMocks
    private ProductServiceImpl productService = new ProductServiceImpl();


    @Before
    public void setUp() throws Exception {
        this.product = Mockito.mock(Product.class);
        when(this.product.getId()).thenReturn(1l);

    }

    @After
    public void tearDown() throws Exception {
        this.product = null;

    }

    @Test
    public void findAll() {
        Iterable<Product> products = IntStream.rangeClosed(1, 10).mapToObj(element -> {


            Product product = new Product();
            product.setId(Long.valueOf(element));
            return product;
        }).collect(Collectors.toList());


        when(this.productrepository.findAll()).thenReturn(products);


        assertEquals(10, this.productService.findAll().size());

    }

    @Test
    public void save() {

        when(this.productrepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product productDb = this.productService.save(product);

        assertEquals(new Long(1), productDb.getId());

    }

    @Test
    public void findOne() {

        when(productrepository.findOne(Mockito.anyLong())).thenReturn(this.product);

        Product productDb = this.productService.findOne(1l).get();

        assertEquals(new Long(1), productDb.getId());
    }

    @Test
    public void delete() {
        doNothing().when(productrepository).delete(Mockito.anyLong());
        this.productService.delete(1l);
        verify(productrepository, times(1)).delete(Mockito.anyLong()); //pretty sure it is verify after call
    }


}