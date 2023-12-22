package com.softproject.SoftProject.repo;

import com.softproject.SoftProject.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Additional methods if needed
}
