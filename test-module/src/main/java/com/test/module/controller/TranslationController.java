package com.test.module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.common.translation.utils.VolcUtils;

@RestController
@RequestMapping("/api/translation")
public class TranslationController {

    @GetMapping("/zh2en")
    public String translateZhToEn(@RequestParam String text) {
        VolcUtils volcUtils = new VolcUtils();
        // return new String("123");
        return volcUtils.zh2en(text);
    }
}
