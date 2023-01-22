package com.email.rest.member;

import com.email.rest.helper.event.edit.MemberEditApplicationEvent;
import com.email.rest.helper.event.registration.MemberRegistrationApplicationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher; //event publisher

    /**
     * 가입
     */
    public Member postMember(Member member) {
        Member savedMember = memberRepository.save(member);
        publisher.publishEvent(new MemberRegistrationApplicationEvent(this, savedMember));

        return savedMember;
    }

    /**
     * 수정
     */
    public Member edit(EditDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).get();
        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPhone(dto.getPhone());

        publisher.publishEvent(new MemberEditApplicationEvent(this, member));
        return member;
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
