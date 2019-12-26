package js.script;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * User: pretty el
 * Date: 2019/12/22
 */
public final class JSScriptBuilt {

    private static String jsonFile = "E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs\\js_funcs.json";

    public static JsonArray listAllScriptsFromJsonFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile));
            Gson gson = new Gson();
            JsonArray array = gson.fromJson(bufferedReader, JsonArray.class);
            if (array.size() > 0) {
                return array;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        listAllScriptsFromJsonFile();
    }
}
