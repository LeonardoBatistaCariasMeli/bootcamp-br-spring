package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.usecase.MorseUseCase;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseUseCaseImpl implements MorseUseCase {
    @Override
    public String convertMorseToUTF8(String morseCode) {
        String[] english = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?" };

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };

        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < english.length ;i++)
            map.put(morse[i],english[i]);

        String[] s = morseCode.split(" ");

        Arrays.stream(s).forEach(a -> System.out.println(a));

      /*
        for (int i = 0; i < chars.length; i++){
            for (int j = 0; j < english.length; j++){

                if (english[j] == chars[i]){
                    str = str + morse[j] + " ";
                }
            }
        }
        System.out.println(str);
    }*/

    return morseCode;
    }
}
