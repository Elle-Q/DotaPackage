package model;

import com.intellij.openapi.util.IconLoader;
import com.intellij.util.PlatformIcons;
import kotlin.jvm.JvmField;

import javax.swing.*;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public class DotaIcons {

    @JvmField
    public static Icon DOTA_ICON = load("/icons/logo1.png");

    private static Icon load(String resourcePath){
        return IconLoader.findIcon(resourcePath);
    }
}
