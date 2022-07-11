package com.batuhankiltac.springSample.service;

import com.batuhankiltac.springSample.model.Category;
import com.batuhankiltac.springSample.repository.CategoryRepository;
import com.batuhankiltac.springSample.service.abstracts.CategoryService;
import com.batuhankiltac.springSample.service.concretes.CategoryManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryManagerTest {

    @InjectMocks
    private CategoryManager categoryManager;

    @Mock
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void it_should_save_category() {
        // Given
        final Category category = Category.builder()
                .categoryId(1)
                .categoryName("test")
                .build();

        // When
        when(categoryManager.add(category)).thenReturn(category);

        // Then
        assertThat(category.getCategoryId()).isNotNull();
        assertThat(category.getCategoryName()).isEqualTo("test");
    }

    @Test
    public void it_should_delete_category() {
        // Given
        final Category category = Category.builder().build();

        // When
        categoryManager.delete(category);

        // Then
        verify(categoryRepository).delete(category);
    }

    @Test
    public void it_should_get_all_categories() {
        // Given
        final Category category1 = Category.builder()
                .categoryId(1)
                .categoryName("test1")
                .build();
        final Category category2 = Category.builder()
                .categoryId(2)
                .categoryName("test2")
                .build();
        final List<Category> all = new ArrayList<>();
        all.add(category1);
        all.add(category2);

        // When
        when(categoryManager.getAll()).thenReturn(all);

        // Then
        assertThat(category1.getCategoryId()).isNotEqualTo(category2.getCategoryId());
        assertThat(category2.getCategoryName()).isEqualTo("test2");
    }
}