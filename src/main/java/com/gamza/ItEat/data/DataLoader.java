//package com.gamza.ItEat.data;
//
//import com.gamza.ItEat.entity.CategoryEntity;
//import com.gamza.ItEat.enums.CategoryName;
//import com.gamza.ItEat.repository.CategoryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    private final CategoryRepository categoryRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        initializeCategories();
//    }
//
//    // 카테고리 초기 enum타입들 데이터베이스에 삽입!
//    private void initializeCategories() {
//        for (CategoryName categoryName : CategoryName.values()) {
//            CategoryEntity categoryEntity = CategoryEntity.builder()
//                    .categoryName(categoryName)
//                    .build();
//            categoryRepository.save(categoryEntity);
//        }
//    }
//}
