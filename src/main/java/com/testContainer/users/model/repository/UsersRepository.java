package com.testContainer.users.model.repository;

import com.testContainer.users.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * JpaRepository를 들어가보면 @NoRepositoryBean 이라는 어노테이션이 존재한다.
 * 해당 어노테이션은 JpaRepository를 상속 받은 클래스에 @Repository 어노테이션이 존재하면 해당 @Repository 어노테이션을 무시한다.
 * @NoRepositoryBean은 실제 사용되는 Repository가 아닌 것을 표현한다.
 */

public interface UsersRepository extends JpaRepository<Users, Long> {

}
