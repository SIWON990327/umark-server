package umc.project.umark.domain.member.service;

import umc.project.umark.domain.member.dto.MemberDto;
import umc.project.umark.domain.member.entity.Member;

import java.io.IOException;
import java.util.List;

public interface MemberService {

    public Boolean sendEmail(String email, String univName) throws IOException;

    public Boolean checkEmail(String email, String univName, int code) throws  IOException;

    public Member signUpMember(String email, String password);
    public MemberDto.MemberResponseDto getMember(Long memberId);
    public List<MemberDto.MemberResponseDto> getAllMembers();
}