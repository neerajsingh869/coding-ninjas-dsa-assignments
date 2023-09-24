package trees;

public class LengthBSTReturn{
    int min;
    int max;
    // height of the largest BST
    int hBST;
    boolean isBST;
    
    public LengthBSTReturn(int min, int max, int hBST, boolean isBST){
        this.min = min;
        this.max = max;
        this.hBST = hBST;
        this.isBST = isBST;
    }
}
