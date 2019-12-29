package contributors;

import com.intellij.codeInsight.completion.CompletionContributor;
import provider.lua.LuaConstantCompletionProvider;
import provider.lua.LuaFuncCompletionProvider;

/**
 * Lua部分Contributor, Lua语言补全类
 * User: pretty el
 * Date: 2019/12/28
 */
public class LuaCompletionContributor extends CompletionContributor {

    public LuaCompletionContributor() {
        new LuaConstantCompletionProvider().addTo(this);
        new LuaFuncCompletionProvider().addTo(this);
    }
}
