public class FlourPacker {
    public static void main(String[] args) {
        /*System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));*/
        System.out.println(canPack(4, 18, 19));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int pack = 0;
        for (int i = bigCount; i > 0; i--) {
            pack += 5;
            if (pack > goal) {
                pack -= 5;
                break;
            } else if (pack == goal) {
                return true;
            }
        }

        for (int i = smallCount; i > 0; i--) {
            pack += 1;
            if (pack > goal) {
                return false;
            } else if (pack == goal) {
                return true;
            }
        }

        return false;
    }
}
