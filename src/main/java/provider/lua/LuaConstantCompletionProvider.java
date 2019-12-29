package provider.lua;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import tool.constants.ConstantsBuilt;
import model.DotaIcons;
import provider.base.AbstractCompletionProvider;
import utils.CompletionProviderUtils;

import java.util.Collection;

/**
 * User: pretty el
 * Date: 2019/12/28
 */
public class LuaConstantCompletionProvider extends AbstractCompletionProvider {
    @Override
    public void addTo(CompletionContributor contributor) {
        PsiElementPattern insideVar = PlatformPatterns.psiElement();
        contributor.extend(CompletionType.BASIC, insideVar, this);
    }

    @Override
    protected void addCustomCompletions(String currentText, CompletionParameters parameters, ProcessingContext context, CompletionResultSet result) {

        PsiElement original = parameters.getOriginalPosition();
        if (null != original) {
             addCollectedVariables(original, result);
        }
    }

    private int addCollectedVariables(PsiElement original, CompletionResultSet result) {
        Collection<LookupElement> items = CompletionProviderUtils.createFromPsiItemsForVal(ConstantsBuilt.luaConstants, DotaIcons.DOTA_ICON_LUA);
        result.addAllElements(items);
        return items.size();
    }
}
