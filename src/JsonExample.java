import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonExample {
    public static void main(String[] args) {
        String[] name=new String[3];
        name[0]="Kim";
        name[1]="Park";
        name[2]="Yi";

        String[] name1=new String[3];
        name1[0]="Kim1";
        name1[1]="Park1";
        name1[2]="Yi1";

        // new StringToJson(name, name1);
        StringToJson converter = new StringToJson(name,name1);
        String jsonString = converter.convertToJsonString();
        System.out.println(jsonString);
    }
}