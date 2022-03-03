package org.exmaple.repository;

import org.exmaple.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// jpaRepository 상속하는 인터페이스. 데이터베이스와 연결될 엔티티객체 , 객체 id 필드타입을 넣어줌
public interface TodoRepsitory extends JpaRepository<TodoEntity,Long> {
}
