package programmers.lv1;

public class Programmers_옹알이2 {

	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int result = solution(babbling);
		System.out.println(result);
	}
	
	public static int solution(String[] babbling) {
        int answer = 0;

        for(int i=0; i<babbling.length; i++) {
            String babble = babbling[i];
            
            int index = 0;
            char preWord = '0';
            
            boolean flag = true;
            while(flag) {
                char test = babble.charAt(index);
                // 앞선 단어와 중복되지 않은지 검사
                // 검사할 단어 길이가 넘어가는지 검사
                // 단어 내용이 같은지 검사
                switch (test) {
                    case 'a': 
                        index = preWord != test && babble.length() >= index+3 && babble.substring(index, index+3).equals("aya") ? index+3 : -1;
                        preWord = test;
                        break;
                    case 'y':
                        index = preWord != test && babble.length() >= index+2 && babble.substring(index, index+2).equals("ye") ? index+2 : -1;
                        preWord = test;
                        break;
                    case 'w':
                        index = preWord != test && babble.length() >= index+3 && babble.substring(index, index+3).equals("woo") ? index+3 : -1;
                        preWord = test;
                        break;
                    case 'm':
                        index = preWord != test && babble.length() >= index+2 && babble.substring(index, index+2).equals("ma") ? index+2 : -1;
                        preWord = test;
                        break;
                    default:
                    	index = -1;
                    	break;
                }
                
                if (index == babble.length()) {
                    answer++;
                    flag = false;
                    System.out.println("babble: " + babble);
                } else if (index == -1) {
                    flag = false;
                }
            }
        }
        
        return answer;
    }

}
