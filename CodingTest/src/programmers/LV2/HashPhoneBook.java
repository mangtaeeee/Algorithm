package programmers.LV2;

import java.util.Arrays;
import java.util.HashMap;

public class HashPhoneBook {
	public boolean solution(String[] phone_book){
        // 1. phone_book 을 정렬한다.
        Arrays.sort(phone_book);
        // 2. 1중 loop를 돌면서 앞번호가 뒷번호의 접두어인지 확인한다.
        for (int i=0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        // 3. 여기까지 오지 못했다면접두어가 없다는것이다.
        return true;
    }
    //Hash를 이용한 풀이
    public boolean solution2(String[] phone_book){
        // 1. HashMap을 만든다
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i < phone_book.length; i++){
            map.put(phone_book[i], 1);
        }
        // 2. 모든 전화번호의 접두어가 HashMap에 있는지 확인한다.
        for(int i=0; i < phone_book.length; i++){
            for (int j=1 ; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        // 3. 여기까지 왔다면 접두어가 없다는것이다.
        return true;
    }
}
