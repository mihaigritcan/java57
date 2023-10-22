package com.example.java57;

import com.example.java57.model.Product;
import com.example.java57.repositoires.ProductRepository;
import com.example.java57.services.ProductService;
import org.hibernate.sql.results.graph.collection.internal.ListInitializerProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepositoryMock;
    @InjectMocks//injectie de mock, spring aduce dependinta de service
    private ProductService productServiceMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeGetAllProducts() {
        Product product1 = new Product(1L, "cafea", 20.00);
        Product product2 = new Product(2L, "lapte", 8.50);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        when(productRepositoryMock.findAll()).thenReturn(productList);
        List<Product> result = productServiceMock.geAllProducts();
        assertEquals(2, result.size());
        assertEquals("cafea", result.get(0).getName());
        assertEquals("lapte", result.get(1).getName());
    }

    @Test
    public void testGetProductById() {

        Product product1 = new Product(1L, "lapte", 8.50);
        Product product2 = new Product(2L, "zahar", 3.50);


        when(productRepositoryMock.findById(1L)).thenReturn(Optional.of(product1));

        Optional<Product> result = productServiceMock.getProductById(1L);
        assertEquals(true, result.isPresent());

        when(productRepositoryMock.findById(2L)).thenReturn(Optional.of(product2));
        Optional<Product> result2 = productServiceMock.getProductById(2L);
        Product p = result2.get();
        assertEquals("zahar", p.getName());
    }

    @Test
    public void testSaveProduct() {
        Product product1 = new Product(1L, "lapte", 8.50);

        productServiceMock.saveProduct(product1);
        verify(productRepositoryMock, times(1)).save(product1);

    }
    @Test
    public void testDeleteProductById(){
        Product product1 = new Product(1L, "lapte", 8.50);
        productServiceMock.saveProduct(product1);
        productServiceMock.deleteProduct(1L);
        verify(productRepositoryMock,times(1)).deleteById(1L);
    }
}
