package com.sparta.springmvc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
//@ModelAttribute 에서 클래스 받아올떄 Setter가 필요함.

public class Star {
    String name;
    int age;

    //롬복의 Setter는 이런 역할을 함. -> 객체에 대해서 멤버변수를 설정해줌.
//    public setName(String name) {
//        this.name = name;
//    }


}