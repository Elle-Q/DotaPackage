package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import js.script.JSScriptBuilt;
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
     * @param icon
     * @return
     */
    public static Collection<LookupElement> createFromPsiItemsForScript(JsonArray array, Icon icon) {
        List<LookupElement> results = new ArrayList<>();
        if (null != array) {
            for (int i = 0; i < array.size(); i++) {
                JsonObject object = (JsonObject) array.get(i);
                String function = object.get("function").getAsString();
                String Signature = object.get("Signature").getAsString();
                String Description = object.get("Description").getAsString();
                LookupElementBuilder element = LookupElementBuilder.create(Signature)
                        .withLookupString(function).withTypeText(Description);
                if (null != icon) {
                    element = element.withIcon(icon);
                }
                results.add(element);
            }
        }
        return results;
    }
}
