//package com.codecool.codecoolshopspring.repository.implementation;
//
//
//import com.codecool.codecoolshopspring.model.category.Category;
//import com.codecool.codecoolshopspring.repository.CategoryRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CategoryRepositoryMem implements CategoryRepository {
//
//    private List<Category> data = new ArrayList<>();
//
//    @Override
//    public void save(Category category) {
//        category.setId(data.size() + 1);
//        data.add(category);
//    }
//
//    @Override
//    public Optional<Category> find(int id) {
//        return data.stream().filter(t -> t.getId() == id).findFirst();
//    }
//
//    @Override
//    public void deleteById(int id) {
//        data.remove(find(id));
//    }
//
//    @Override
//    public List<Category> findAll() {
//        return data;
//    }
//}
