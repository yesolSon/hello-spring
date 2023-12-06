package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null값이더라도 감싸서 반환가능->클라이언트쪽에서 처리하도록.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()//루프를 돌림.
                .filter(member -> member.getName().equals(name)) //store에 저장된 member에서 파라미터로 넘어온 name값과 같은 이름을 가진 것들을 필터링
                .findAny(); //그 중에서 같은 걸 찾으면 반환(Optional로 반환됨)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();

    }
}
