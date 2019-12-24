package js.script;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Set;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public final class JSScriptBuilt {
    public static final HashMap<String, Set<String>> jsScripts = new HashMap<String, Set<String>>() {{
        put("GameEvents.SendCustomGameEventToAllClients", Sets.newHashSet("GameEvents.SendCustomGameEventToAllClients(cstring pEventName, jsObject jsObject)","Send a custom game event to the server, which will send it to all clients"));
        put("GameEvents.Subscribe", Sets.newHashSet("GameEvents.Subscribe(cstring pEventName, js_value funcVal)","Subscribe to a game event"));
        put("GameEvents.Unsubscribe",Sets.newHashSet("GameEvents.Unsubscribe(integer nCallbackHandle)","Unsubscribe from a game event"));
    }};
}
