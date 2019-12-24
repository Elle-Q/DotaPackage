package utils;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import model.DotaIcon;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 代码自动补全创建元素工具
 * User: pretty el
 * Date: 2019/12/22
 */
public class CompletionProviderUtils {

    /**
     * 创建js常量部分
     *
     * @param jsConstants
     * @return
     */
    public static Collection<LookupElement> createFromPsiItemsForVal(Collection<String> jsConstants, Icon icon) {
        return jsConstants.stream().map(jsConstant -> {
            LookupElementBuilder element = LookupElementBuilder.create(jsConstant);
            if (null != icon) {
                element = element.withIcon(icon);
            }
            return element;
        }).collect(Collectors.toList());
    }

    /**
     * 创建js脚本部分
     *
     * @param jsScripts
     * @return
     */
    public static Collection<LookupElement> createFromPsiItemsForScript(HashMap<String, Set<String>> jsScripts, Icon icon) {
        List<LookupElement> results = new ArrayList<>();
        jsScripts.forEach((k,v) -> {
            LookupElementBuilder element = LookupElementBuilder.create(v.toArray()[0])
                    .withLookupString(k).withTypeText((String) v.toArray()[1]);
            if (null != icon) {
                element = element.withIcon(icon);
            }
            results.add(element);
        });
        return results;
    }
}
