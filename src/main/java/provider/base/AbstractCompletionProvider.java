package provider.base;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public abstract class AbstractCompletionProvider extends CompletionProvider<CompletionParameters> {

    public AbstractCompletionProvider() {
    }

    /**
     * 将provider添加到contributor
     * @param contributor
     */
    public abstract void addTo(CompletionContributor contributor);

    @Override
    protected final void addCompletions(@NotNull CompletionParameters parameters,
                                        ProcessingContext context,
                                        @NotNull CompletionResultSet resultWithoutPrefix) {
        addCustomCompletions(findCurrentText(parameters, parameters.getPosition()), parameters, context, resultWithoutPrefix);
    }

    protected abstract void addCustomCompletions(String currentText, CompletionParameters parameters, ProcessingContext context, CompletionResultSet result);

    protected String findCurrentText(CompletionParameters parameters, PsiElement element) {
        String originalText = findOriginalText(element);
        int elementOffset = parameters.getOffset() - element.getTextOffset();

        return (elementOffset >= 0) && (elementOffset < originalText.length())
                ? originalText.substring(0, elementOffset)
                : originalText;
    }

    protected String findOriginalText(PsiElement element) {
        return element.getText();
    }
}
