package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {
    ArrayList<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product("Chi tu", 3000));
        Product.count = Product.count + 1;
        products.add(new Product("Danh danh", 4000));
        Product.count = Product.count + 1;
        products.add(new Product("Phong tu", 2500));
        Product.count = Product.count + 1;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public ArrayList<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
        Product.count = Product.count + 1;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product findById(int id) {
        return products.get(findIndexById(id));
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> listByName = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().matches(name+".*")) {
                listByName.add(products.get(i));
            }
        }
        return listByName;
    }

    @Override
    public ArrayList<Product> findByPrice(double minPrice, double maxPrice) {
        ArrayList<Product> listByPrice = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if ((products.get(i).getPrice() <= maxPrice) && (products.get(i).getPrice() >= minPrice)) {
                listByPrice.add(products.get(i));
            }
        }
        return listByPrice;
    }

    @Override
    public void update(int id, Product product) {
        products.set(findIndexById(id), product);
    }

    @Override
    public void remove(int id) {
        products.remove(findIndexById(id));
    }
}
