package utils;

import com.google.gson.*;

import java.io.*;

/**
 * 处理文件的工具类，用来解析恶心的txt文件
 * User: pretty el
 * Date: 2019/12/24
 */
public class FileUtill {


    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("E:\\GradelDemos\\DotaPackage\\src\\main\\resources\\docs\\cl_panorama_script_help_2.txt");
            BufferedReader br = new BufferedReader(file);
            int lineNum = 0;//文件行数
            String line = "";
            boolean flag = false;
            JsonObject funcJson = new JsonObject();
            JsonArray array = new JsonArray();
            while (null != (line = br.readLine())) {
                boolean isSave = false;
                if (flag) {
                    flag = false;
                    isSave = true;
                    funcJson.addProperty("Description", line.replace("|", "").trim());
                }
                if (line.contains("<code>")) {
                    funcJson = new JsonObject();
                    flag = true;
                    String result = line.replace("<code>", "")
                            .replace("</code>", "").replace("|", "").trim();
                    funcJson.addProperty("function",result.split("\\(")[0]);
                    funcJson.addProperty("Signature", result);
                }
                if (isSave && funcJson.size() > 1) {
                    array.add(funcJson);
//                    System.out.println(funcJson.toString());
                }
            }
            System.out.println("共创建对象：" + array.size() + "个");
            System.out.println(array.toString());
            //生成json格式文件
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(array.toString());
            String prettyJoson = gson.toJson(je);
            File jsonFile = new File("E:\\\\GradelDemos\\\\DotaPackage\\\\src\\\\main\\\\resources\\\\docs\\\\js_funcs.json");
            if (!jsonFile.getParentFile().exists()) {
                jsonFile.mkdirs();
            }
            if (jsonFile.exists()) {
                jsonFile.delete();
            }
            jsonFile.createNewFile();
            //将格式化后的字符串写入文件
            Writer writer = new OutputStreamWriter(new FileOutputStream(jsonFile),"utf-8");
            gson.toJson(je, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
