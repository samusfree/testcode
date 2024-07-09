import java.util.*;

/*

Given a list of Strings, return a Set of Sets,
each of which contains all strings which acather.

Example:

input = ["cats", "redraw", "tap", "dog", "pat", "acts", "drawer",
 "remote", "reward", "god"]


Output = {
 acst -> {'cats', 'acts'},
  {'redraw', 'drawer', 'reward'},
  {'tap','pat'},
  {'dog','god'},
  {'remote'}
}


*/

public class Test0106 {

    public static void main (String[] args) {
        List<String> input = Arrays.asList("cats", "redraw", "tap", "dog", "pat",
                "acts", "drawer", "remote", "reward", "god");

        //is not requires really but for validations
        if(input.size()<=0) {
            System.out.println("Not lements");
        }

        if(input.size()==1) {
            System.out.println(input.get(0));
        }

        Map<String, List<String>> result = new HashMap<>();

        for(int i = 0; i < input.size(); i++) {
            boolean found = false;
            String key = sortString(input.get(i));

            if(result.get(key)!= null) {
                result.get(key).add(key);
                found = true;
            }
            /*
            for(String keyMap: result.keySet()) {
                if(keyMap.equals(key)) {
                    result.get(keyMap).add(key);
                    found = true;
                }
            }*/

            if(!found) {
                List<String> values = new ArrayList<>();
                values.add(key);
                result.put(key, values);
            }
        }

        for(String keyMap: result.keySet()) {
            System.out.println(result.get(keyMap));
        }

    }

    static String sortString(String value) {
        char[] tempArray = value.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}

