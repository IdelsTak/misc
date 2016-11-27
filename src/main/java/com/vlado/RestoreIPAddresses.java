package com.vlado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

    public static void main(String[] args) {
        new RestoreIPAddresses().restoreIpAddresses("25525511135");
    }

    LinkedList<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        IpAddress a = new IpAddress();
        dfs(s, a, 0);
        return result;
    }

    public boolean dfs(String string, IpAddress address, int start) {
        if (start < string.length() && !address.isComplete()) {
            for (int i = 1; i < 4; i++) { //count the digits inside a single path
                int end = start + i;
                if (string.length() >= end) {
                    String temp = string.substring(start, end);
                    if (address.isValid(temp)) {
                        if (!address.isComplete()) {
                            address.addSegment(temp);
                            boolean successful = dfs(string, address, end);
                            if (!successful) {
                                address.removeLastSegment();
                            } else {
                                return true;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        } else if (start == string.length() && address.isComplete()) {
            result.add(address.toString());
        }
        return false;
    }

    public class IpAddress {
        private static final int SEGMENT_SIZE = 4;

        LinkedList<String> segments = new LinkedList<>();

        public boolean addSegment(String segment) {
            if (!isComplete()) {
                segments.add(segment);
                return true;
            }
            return false;
        }

        public void removeLastSegment() {
            segments.removeLast();
        }

        public boolean isComplete() {
            return segments.size() >= SEGMENT_SIZE;
        }

        public boolean isValid(String temp) {
            if(temp.charAt(0) == '0') return temp.length() == 1;
            int num = Integer.valueOf(temp);
            return num >=0 && num <= 255;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < segments.size(); i++) {
                sb.append(segments.get(i));
                if (i < segments.size() - 1) {
                    sb.append(".");
                }
            }
            return sb.toString();
        }
    }

}
