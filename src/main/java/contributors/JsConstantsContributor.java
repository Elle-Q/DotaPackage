package contributors;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.openapi.util.IconLoader;
import provider.ConstantCompletionProvider;
import provider.ScriptCompletionProvider;

import javax.swing.*;

/**
 * js部分-常量Contributor
 * User: pretty el
 * Date: 2019/12/22
 */
public class JsConstantsContributor extends CompletionContributor {

    public JsConstantsContributor() {
        new ConstantCompletionProvider().addTo(this);
        new ScriptCompletionProvider().addTo(this);
    }
}
