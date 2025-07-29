// === 計算複雜度分析 ===
// 時間複雜度：O(n^2)
// 空間複雜度：O(n)

import java.util.*;
public class F03_ConvenienceHotItems {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Item> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String name = sc.next();
            int qty = sc.nextInt();
            list.add(new Item(name, qty));
        }
        for(int i=1; i<list.size(); i++){
            Item key = list.get(i);
            int j = i - 1;
            while(j >= 0 && list.get(j).qty < key.qty){
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
        int limit = Math.min(10, list.size());
        for(int i=0; i<limit; i++){
            System.out.println(list.get(i).name + " " + list.get(i).qty);
        }
    }
    static class Item {
        String name;
        int qty;
        Item(String n, int q){ name = n; qty = q; }
    }
}