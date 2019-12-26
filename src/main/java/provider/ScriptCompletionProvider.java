package provider;

import com.google.gson.JsonArray;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import js.script.JSScriptBuilt;
import model.DotaIcons;
import utils.CompletionProviderUtils;

import java.util.Collection;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public class ScriptCompletionProvider extends AbstractCompletionProvider{

    @Override
    public void addTo(CompletionContributor contributor) {
        PsiElementPattern insideVar = PlatformPatterns.psiElement();
        contributor.extend(CompletionType.BASIC, insideVar, this);
    }

    @Override
    protected void addCustomCompletions(String currentText, CompletionParameters parameters, ProcessingContext context, CompletionResultSet result) {
        PsiElement element = parameters.getPosition();
        int invocationCount = parameters.getInvocationCount();
        int resultLength = 0;

        PsiElement original = parameters.getOriginalPosition();
        if (null != original) {
            resultLength += addCollectedVariables(original, result);
            System.out.println("create script:" + resultLength);
        }
    }

    /**
     * 开始添加dota_js常量d到查找结果集
     * @param element
     * @param result
     * @return
     */
    private int addCollectedVariables(PsiElement element, CompletionResultSet result) {
        JsonArray array = JSScriptBuilt.listAllScriptsFromJsonFile();
        Collection<LookupElement> items = CompletionProviderUtils.createFromPsiItemsForScript(array, DotaIcons.DOTA_ICON_JS);
        result.addAllElements(items);
        return items.size();
    }
}
