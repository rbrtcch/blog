package com.egnyte.blog.server.DAO;

import com.egnyte.blog.server.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogDAO extends JpaRepository<Blog, Long> {}