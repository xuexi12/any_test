package com.test.common.translation.utils;

import com.test.common.translation.exception.TranslationException;
import com.volcengine.model.request.translate.TranslateTextRequest;
import com.volcengine.model.response.translate.TranslateTextResponse;
import com.volcengine.service.translate.ITranslateService;
import com.volcengine.service.translate.impl.TranslateServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于火上引擎翻译
 */
public class VolcUtils {
    static ITranslateService translateService = TranslateServiceImpl.getInstance();

    static {
        // todo 替换为实际的密钥
        translateService.setAccessKey("ak");
        translateService.setSecretKey("sk");
    }


    public static List<String> translate(List<String> waitTranslate, String sourceLanguage, String targetLanguage) {
        List<String> translateResult = new ArrayList<>();
        if (CollectionUtils.isEmpty(waitTranslate)) {
            return translateResult;
        }
        if (StringUtils.isBlank(targetLanguage)) {
            throw new TranslationException("目标语言不能为空");
        }

        try {
            TranslateTextRequest translateTextRequest = new TranslateTextRequest();
            // 不设置表示自动检测
            if (StringUtils.isNotBlank(sourceLanguage)) {
                translateTextRequest.setSourceLanguage(sourceLanguage);
            }
            translateTextRequest.setTargetLanguage(targetLanguage);

            // 请求限制qps=10，列表长度=16，总文本长度=5000
            for (List<String> itemList : ListUtils.partition(waitTranslate, 16)) {
                int codeLen = 0;
                int codeStart = 0;
                List<String> translateList;
                for (int i = 0; i < itemList.size(); i++) {
                    String trim = itemList.get(i).trim();
                    itemList.set(i, trim);
                    codeLen += trim.length();
                    if (codeLen > 5) {
                        translateList = itemList.subList(codeStart, i + 1);
                        limitTranslate(translateResult, translateList, translateTextRequest);
                        codeLen = 0;
                        codeStart = i + 1;
                    }
                }

                if (codeStart < itemList.size()) {
                    translateList = itemList.subList(codeStart, itemList.size());
                    limitTranslate(translateResult, translateList, translateTextRequest);
                }
            }

        } catch (Exception e) {
            throw new TranslationException(e.getMessage(), e);
        }

        return translateResult;
    }

    static void limitTranslate(List<String> translateResult, List<String> translateList, TranslateTextRequest translateTextRequest) throws Exception {
        if (CollectionUtils.isEmpty(translateList)) {
            return;
        }

        translateTextRequest.setTextList(translateList);
        TranslateTextResponse translateText = translateService.translateText(translateTextRequest);
        translateResult.addAll(translateText.getTranslationList().stream().map(TranslateTextResponse.Translation::getTranslation).toList());

        Thread.sleep(101);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("你");
        list.add("好");
        list.add("你");
        list.add("好");
        list.add("你");
        list.add("好");

        List<String> translate = translate(list, "zh", "en");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + ":" + translate.get(i));
        }

    }

}
