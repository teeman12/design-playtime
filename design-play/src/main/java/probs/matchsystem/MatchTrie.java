package probs.matchsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchTrie {


    private AttrNode root;

    MatchTrie(){
        root = new AttrNode();
    }

    public void addMatchValue(List<String> strs, String val) {
        AttrNode cur = findLastNode(strs);
        if (!strs.isEmpty()) {
            cur.output = val;
        }
    }

    public String findMatchVal(List<String> strs){
        AttrNode cur = findLastNode(strs);
        return cur.output;
    }

    private AttrNode findLastNode(List<String> strs) {
        AttrNode cur = root;
        for (String s : strs) {
            if (s == null) {
                if (cur.defNode == null) {
                    cur.defNode = new AttrNode();
                }
                cur = cur.defNode;
            } else {
                cur = cur.cNodes.computeIfAbsent(s, a -> new AttrNode());
            }
        }
        return cur;
    }


    private static class AttrNode {
        String output;
        Map<String, AttrNode> cNodes;
        AttrNode defNode;

        AttrNode() {
            cNodes = new HashMap<>();
            defNode = null;
        }
    }

}
