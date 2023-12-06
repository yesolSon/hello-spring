package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//optional 사용하는 이유? null로 반환되는 대신 감싸서 반환하도록
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
