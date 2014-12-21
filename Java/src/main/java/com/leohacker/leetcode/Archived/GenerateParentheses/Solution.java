package com.leohacker.leetcode.Archived.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * I really like this solution, effective, efficient, and simple.
 */
public class Solution {
    private class Candidate {
        public String str;
        public int left;
        public int right;

        public Candidate() {
            str = "";
            left = 0;
            right = 0;
        }

        public Candidate(Candidate can) {
            this.str = can.str;
            this.left = can.left;
            this.right = can.right;
        }
    }

    enum ParenType {
        LEFT, RIGHT
    }

    public List<String> generateParenthesis(int n) {
        Candidate candidate = new Candidate();
        candidate.left = n;
        candidate.right = n;

        List<Candidate> listCandidate = new ArrayList<Candidate>();
        listCandidate.add(candidate);

        for (int i = 0; i < 2 * n; i++) {
            List<Candidate> nextListCandidate = new ArrayList<Candidate>();
            for (Candidate can : listCandidate) {
                addCandidate(nextListCandidate, can, ParenType.LEFT);
                addCandidate(nextListCandidate, can, ParenType.RIGHT);
            }
            listCandidate = nextListCandidate;
        }

        List<String> list = new ArrayList<String>();
        for (Candidate can : listCandidate) {
            list.add(can.str);
        }
        return list;
    }

    private void addCandidate(List<Candidate> list, Candidate can, ParenType type) {
        if ( type == ParenType.LEFT && can.left > 0 ) {
            Candidate tmp = new Candidate(can);
            tmp.left--;
            tmp.str = tmp.str + "(";
            list.add(tmp);
        }
        if ( type == ParenType.RIGHT && ((can.right - can.left) > 0) ) {
            Candidate tmp = new Candidate(can);
            tmp.right--;
            tmp.str = tmp.str + ")";
            list.add(tmp);
        }
    }
}
