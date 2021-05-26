package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.entrypoint.controller.requests.MorseRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.MorseUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseConverterController {
    private final MorseUseCase morseUseCase;

    public MorseConverterController(MorseUseCase morseUseCase) {
        this.morseUseCase = morseUseCase;
    }

    @PostMapping()
    public String convertMorseToUTF8(@RequestBody MorseRequest morse){
        return  morseUseCase.convertMorseToUTF8(morse.morse);
    }



}
