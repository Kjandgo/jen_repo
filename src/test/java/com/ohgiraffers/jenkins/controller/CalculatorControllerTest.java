package com.ohgiraffers.jenkins.controller;


import com.ohgiraffers.jenkins.dto.CalculatorDTO;
import com.ohgiraffers.jenkins.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class CalculatorControllerTest {

    @Autowired
    CalculatorService calculatorService;

    private static Stream<Arguments> provideDTOSource() {
        return Stream.of(
                Arguments.of(new CalculatorDTO(1, 2)),
                Arguments.of(new CalculatorDTO(3, 5)),
                Arguments.of(new CalculatorDTO(10, -2))
        );
    }


    @ParameterizedTest
    @MethodSource("provideDTOSource")
    public void 두_수의_합_구하기_테스트(CalculatorDTO input){
        int expected = input.getNum1()+input.getNum2();
        int actual = calculatorService.plusTwoNumbers(input);

        Assertions.assertEquals(expected, actual);
    }
}