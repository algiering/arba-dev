package pt02;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Alphabet {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        String s = "This was a great help. I applied this method to similiar problem and rather than concat a SELECT statement I created an event scheduled every couple hours to rebuild a view that pivots n amount of rows from one table into n columns on the other. It's a big help because before I was rebuilding the query using PHP on every execution of the SELECT. Even though views can't leverage Indexes, I'm thinking filtering performance won't be an issue as the pivoted rows->columns represent types of training employees at a franchise have so the view won't ever break a few thousand rows.";

        // 스트링 값을 모두 대문자로 변환
        s = s.toUpperCase();

        String key, val = "";

        for (int i = 0; i < s.length(); i = i + 1) {
            
            // 한글자씩 자르기
            key = s.substring(i, i + 1);

            // key 값이 처음 들어갈때 key를 인덱스로 가진 map이 없기때문에 key는 위에서 자른값(알파벳), val의 첫번째 값은 :가 됨(구분) 
            // => key가 A라면 A가 처음들어갈때 map(A, val)은 아직 put되지 않았으므로 key="A" val=":" 값을 가지게됨
            if (map.get(key) == null) {
                val = ":";
            }
            // key값이 null이 아니고 이미 들어간경우에 val 값에 key값을 넣음
            // => key가 A라면 위에 이미 한번 A값이 key에 들어가 map.put("A",":") 된 후에 
            //    위의 map.get(key) == null 조건을 만족하지 않게 되어 else로 들어가게 됨
            //    처음 put 될때 key에 따른 val값에 *이 들어갔으므로 위의 조건이 만족하지 않으면 map.get(key)의 값은 *이 되어
            //    key = A, val = * 가 됨
            else {
                val = map.get(key);
            }
            // key값이 대문자 A~Z 일때 key, val+* 을 맵에 추가시킴 -> 결국 한글자씩 잘라서 만들어진 key 값이 A~Z일때 각 알파벳에 맞는 val의 *갯수가 하나씩 증가하게됨
            // => key = A~Z사이 이므로 
            // Hashmap은 key값의 중복이 불가능하므로 알파벳 대문자(key)의 값이 A~Z가 되면 밑에 조건으로 들어가게 되어
            // map.put( A, val(*)+"*" ) 즉 val의 문자열은 밑의 조건을 만족할때마다 *이 하나씩 추가되게 됨
            if ((key.charAt(0) >= 'A') && (key.charAt(0) <= 'Z')) {

                map.put(key, val + "*");
            }
        }

        for (Entry<String, String> e : map.entrySet()) {
            
            // Entry set을 이용해서 map의 key(알파벳 대문자)와 value값 출력
            System.out.println(String.format("%s%s", e.getKey(), e.getValue()));
        }

    }
}
