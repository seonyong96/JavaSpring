package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositotyTest {

    MemberRepository repositoty = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositoty.save(member);

        Member result = repositoty.findById(member.getId()).get();
        // Assertions.assertEquals(result, member);
        // Assertions.assertEquals(member, null);
        Assertions.assertThat(member).isEqualTo(result);
    }
}
