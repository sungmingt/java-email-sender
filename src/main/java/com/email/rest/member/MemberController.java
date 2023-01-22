package com.email.rest.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity register(@RequestBody Member member) {
        memberService.postMember(member);
        return new ResponseEntity("success", CREATED);
    }

    @PatchMapping("/members/{memberId}")
    public ResponseEntity edit(@PathVariable("memberId") long memberId,
                               @RequestBody Member member) {
        member.setMemberId(memberId);
        memberService.edit(new EditDto(member));

        return new ResponseEntity("success", OK);
    }



}
