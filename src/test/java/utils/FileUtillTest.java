package utils;

import com.google.gson.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 以下test真实有效，勿删
 * User: pretty el
 * Date: 2019/12/28
 */
public class FileUtillTest {

    /**
     * 生成文档中的lua函数的补全json
     */
    @Test
    public void parseJsonFile() {
        List<String> paths = new ArrayList<String>() {{
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\base-function.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\Functions.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\math.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\ModifierLua.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\string.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\table.sublime-completions.json");
            add("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs.lua\\TempCannotDump.sublime-completions.json");
        }};
        JsonArray arrayResult = new JsonArray();
        String toJsonFilePath = "E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs\\js\\lua_funcs.json";
        JsonParser parse = new JsonParser();  //创建json解析器
        paths.forEach(path -> {
            try {
                JsonObject json = (JsonObject) parse.parse(new FileReader(path));  //创建jsonObject对象
                JsonArray array = json.get("completions").getAsJsonArray();
                if(null != array && array.size() > 0) {
                    array.forEach(a -> {
                        a.getAsJsonObject().get("contents").getAsString().replace("$","");
                    });
                }
                 arrayResult.addAll(array);
            } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        FileUtill.createJsonFileFromArray(arrayResult, toJsonFilePath);
    }

    /**
     * 生成js中的函数补全json文件
     */
    @Test
    private static void parseJsScriptCompletion() {
        String textFilePath = "E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs\\js\\cl_panorama_script_help_2.txt";
        String toJsonFilePath = "E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs\\js\\js_funcs.json";
        FileUtill.parseJsScriptCompletion(textFilePath, toJsonFilePath);
    }
}
