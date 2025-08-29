package com.example.GoCafe.dto;

import com.example.GoCafe.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {

    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private Long memberAge;
    private String memberGender;
    private String memberRole;
    private java.time.LocalDateTime memberDate;
    private String memberPhoto;
    private Long tokenVersion;

    public Member toEntity() {
        return new Member(
                memberId,
                memberEmail,
                memberPassword,
                memberNickname,
                memberAge,
                memberGender,
                memberRole,
                memberDate,
                memberPhoto,
                tokenVersion
        );
    }
}
