package com.hej.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Posts클래스로 DB를 접근하게 해줄 JPA repository
public interface PostsRepository  extends JpaRepository<Posts,Long> {
}
