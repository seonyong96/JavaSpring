package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositotyTest {

    MemoryMemberRepository repositoty = new MemoryMemberRepository();

    @AfterEach
    public void agerEach(){
        repositoty.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositoty.save(member);

        Member result = repositoty.findById(member.getId()).get();
        //System.out.println("result = "+ (result==member));

        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoty.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoty.save(member2);

        Member result = repositoty.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoty.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoty.save(member2);

        List<Member> result = repositoty.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
