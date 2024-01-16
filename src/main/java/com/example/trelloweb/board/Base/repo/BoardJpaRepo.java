package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* JPA Repo역시 extends JpaRepository<class1,class2> class1의 경우 테이블에서 꺼내온 데이터를 담을
* Vo를 넣어주어야합니다. 그리고 class2의 경우 class1에 넣어준 Vo의 @Id를 가지는 어노테이션의 자료형을
* 적어주어야합니다.
* 그리고 리턴값이 Optional<class1>인 이유는 Vo하나를 꺼내오는 경우 JPA가 NullException을 대비해 Optional
* 클래스에 담아서 나오기 때문입니다.
* 이 부분 중요합니다 다른 코드 잘 가져오는 것은 좋습니다, 하지만 그냥 가져오는게 아니라 어떤 흐름인지
* 읽고 가져와주시면 감사드리겠습니다.*/

@Repository
public interface BoardJpaRepo extends JpaRepository<BoardVo,Long> {
}

