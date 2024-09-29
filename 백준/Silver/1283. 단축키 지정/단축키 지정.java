import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> registered = new HashSet<>(); //단축키 등록
        StringBuilder sb = new StringBuilder();

        for (int now = 0; now < N; now++) {
            String[] arr = br.readLine().split(" ");  // 단어 분리

            // 1. 단어의 첫 글자로 단축키 지정 시도
            if (firstLetter(arr, registered)) {
                sb.append(String.join(" ", arr)).append("\n");
                continue;
            }

            // 2. 첫 글자가 이미 지정된 경우, 단어 내 다른 글자로 단축키 지정 시도
            if (anyLetter(arr, registered)) {
                sb.append(String.join(" ", arr)).append("\n");
                continue;
            }

            // 3. 단축키를 지정하지 못한 경우 그대로 출력
            sb.append(String.join(" ", arr)).append("\n");
        }
        System.out.println(sb);
    }// end of main

    // 첫 글자로 단축키 지정 시도
    private static boolean firstLetter(String[] arr, Set<Character> registered) {
        for (int i = 0; i < arr.length; i++) {
            char firstChar = arr[i].charAt(0);
            if (!isRegistered(firstChar, registered)) {
                registerShortcut(firstChar, registered);  // 단축키 등록
                arr[i] = wrap(arr[i], 0);  // 첫 글자에 괄호 삽입
                return true;  // 단축키 지정 완료
            }
        }
        return false;  // 첫 글자로 단축키 실패
    }

    // 다른 글자로 단축키 지정 시도
    private static boolean anyLetter(String[] arr, Set<Character> registered) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                char currentChar = arr[i].charAt(j);
                if (!isRegistered(currentChar, registered)) {
                    registerShortcut(currentChar, registered);  // 단축키 등록
                    arr[i] = wrap(arr[i], j);  // 해당 글자에 괄호 삽입
                    return true;  // 단축키 완료
                }
            }
        }
        return false;  // 단축키 실패
    }

    // 이미 등록되었는지
    private static boolean isRegistered(char c, Set<Character> registered) {
        return registered.contains(Character.toLowerCase(c)) || registered.contains(Character.toUpperCase(c));
    }

    // 단축키 등록 (대소문자 모두 등록)
    private static void registerShortcut(char c, Set<Character> registered) {
        registered.add(Character.toLowerCase(c));
        registered.add(Character.toUpperCase(c));
    }

    // 괄호를 씌움
    private static String wrap(String word, int pos) {
        return word.substring(0, pos) + "[" + word.charAt(pos) + "]" + word.substring(pos + 1);
    }

} // end of class
