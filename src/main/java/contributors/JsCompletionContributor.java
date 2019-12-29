package contributors;

import com.intellij.codeInsight.completion.CompletionContributor;
import provider.js.JsConstantCompletionProvider;
import provider.js.ScriptCompletionProvider;

/**
 * js部分Contributor, javaScript语言补全类
 * User: pretty el
 * Date: 2019/12/22
 */
public class JsCompletionContributor extends CompletionContributor {

    public JsCompletionContributor() {
        new JsConstantCompletionProvider().addTo(this);
        new ScriptCompletionProvider().addTo(this);
    }
}
