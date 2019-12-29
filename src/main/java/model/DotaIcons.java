package model;

import com.intellij.openapi.util.IconLoader;
import kotlin.jvm.JvmField;

import javax.swing.*;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public class DotaIcons {

    @JvmField
    public static Icon DOTA_ICON_LUA = load("/icons/dota_lua.png");

    @JvmField
    public static Icon DOTA_ICON_JS = load("/icons/dota_js2.png");

    private static Icon load(String resourcePath){
        return IconLoader.findIcon(resourcePath);
    }
}
