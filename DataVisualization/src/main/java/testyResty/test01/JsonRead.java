package testyResty.test01;

import org.json.JSONArray;
import org.json.JSONObject;
 
import java.util.HashMap;
import java.util.Map;

public class JsonRead {
    private String file;

    public JsonRead(String file) {
        this.file = file;
    }

    public Map<String, Double> read() {
        JSONObject obj = new JSONObject(file);


        JSONArray names = (JSONArray) obj.get("ballotResult");

        Map<String, Double> wyn = new HashMap<>();
        String p1;
        Double i1;
        for (int i=0;i<names.length();i++) {
            p1 = names.getJSONObject(i).getString("name");
            i1 = Double.valueOf(String.valueOf(names.getJSONObject(i).getInt("votes")));
            wyn.put(p1, i1);
        }

        return wyn;
    }

}
