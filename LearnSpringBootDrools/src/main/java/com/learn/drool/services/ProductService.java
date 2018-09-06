package com.learn.drool.services;

import com.learn.drool.data.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	List<Product> products = new ArrayList<>();

	@Autowired KieContainer kieContainer;

	public Product getProduct(int id) {
		Optional<Product> optionalProduct = getProductById(id);
		if(!optionalProduct.isPresent()) {
			return Product.createProduct(-1, "product not found", 0);
		}

		return computePrice(optionalProduct.get());
	}

	private Product computePrice(Product product) {
		KieSession kieSession = kieContainer.newKieSession("productSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}

	@PostConstruct
	public void initProductService() {
		for(int i=0; i<10; i++) {
			products.add(Product.createProduct(i, "product" + i, i*i*i));
		}
		products.add(Product.createProduct(10, "diamond", 100));
		products.add(Product.createProduct(11, "gold", 100));
	}

	private Optional<Product> getProductById(final int productId) {
		return  products.stream()
				.filter(product -> product.getId() == productId)
				.findFirst();
	}

}
