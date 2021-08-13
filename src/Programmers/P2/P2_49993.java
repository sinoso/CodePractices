package Programmers.P2;

public class P2_49993 {
    public static void main(String[] args) {
//        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//        System.out.println(solution("CBD", new String[]{"ABCD", "DBC", "AECB", "CED"}));
//        System.out.println(solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"}));
        System.out.println(solution("CBDK", new String[]{"CB","AD","B","A"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int length = skill.length();
        int answer = skill_trees.length;
        int[] skillIdx;
        //선행 스킬 마다 index를 부여한다.
        for (String currentTree : skill_trees) {
            skillIdx = new int[length];
            for (int i = 0; i < length ; i++) {
                char currentC = skill.charAt(i);
                int index = currentTree.indexOf(currentC);
                skillIdx[i] = index != -1 ? index : 27;
                if (i > 0 && skillIdx[i] < skillIdx[i - 1]) {
                    answer--;
                    break;
                }
                if (i == 0 && skillIdx[i] == 27 && skill.contains(String.valueOf(currentTree.charAt(0)))) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
