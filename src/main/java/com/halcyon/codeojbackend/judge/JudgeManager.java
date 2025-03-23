package com.halcyon.codeojbackend.judge;

import com.halcyon.codeojbackend.judge.strategy.DefaultJudgeStrategy;
import com.halcyon.codeojbackend.judge.strategy.JavaLanguageJudgeStrategy;
import com.halcyon.codeojbackend.judge.strategy.JudgeContext;
import com.halcyon.codeojbackend.judge.strategy.JudgeStrategy;
import com.halcyon.codeojbackend.model.dto.questionsubmit.JudgeInfo;
import com.halcyon.codeojbackend.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}