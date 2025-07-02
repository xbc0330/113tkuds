class loopc {
    public static void main(String[] args) {
        int x = 0;
        int count = 0;
        do {
            count++;
        } while (++x <= 100);  
        System.out.println("count: " + count);
        System.out.println("x: " + x);        
    }
}