package com.example.examenyoussefchanane.Repository;

import com.example.examenyoussefchanane.Entity.Category;
import com.example.examenyoussefchanane.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {
}
